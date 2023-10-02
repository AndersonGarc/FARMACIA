package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class ProductoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarProducto() {
        
        DefaultTableModel tabla_temporal;
        String[] cabesera = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CATE", "ID_MAR", "ID_MED"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, cabesera);
        sql = "select pSerie,pDescripcion,pObservacion,digemi,pCondicion,caNombre,maNombre,mPresentacion,c.idCategoria,m.idmarca,me.idmedida from producto as p\n"
                + "inner join marca as m on p.idmarca=m.idmarca "
                + "inner join medida as me on p.idmedida=me.idmedida "
                + "inner join categoria as c on p.idCategoria=c.idCategoria limit 0,100";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("caNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar producto", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public boolean registrarProducto(Producto p) {
        boolean rpta = false;
        sql = "insert into producto(pSerie,pDescripcion,pObservacion,digemi,pCondicion,idCategoria,idmarca,idmedida)values(?,?,?,?,?,?,?,?) ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getpSerie());
            pst.setString(2, p.getpDescripcion());
            pst.setString(3, p.getpObservacion());
            pst.setString(4, p.getDigemi());
            pst.setString(5, p.getpCondicion());
            pst.setInt(6, p.getIdCategoria());
            pst.setInt(7, p.getIdmarca());
            pst.setInt(8, p.getIdmedida());
            rpta = pst.executeLargeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar producto", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarProducto(String serie) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CATE", "ID_MAR", "ID_MED"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, registros);
        sql = "select pSerie,pDescripcion,pObservacion,digemi,pCondicion,caNombre,maNombre,mPresentacion,c.idCategoria,m.idmarca,me.idmedida from producto as p "
                + "inner join marca as m on p.idmarca=m.idmarca "
                + "inner join medida as me on p.idmedida=me.idmedida "
                + "inner join categoria as c on p.idCategoria=c.idCategoria "
                + "where pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serie);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("caNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");
            }
            tabla_temporal.addRow(registros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar producto", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public boolean modificarProducto(Producto p) {
        boolean rpta = false;
        sql = "update producto set pDescripcion=?,pObservacion=?,digemi=?,pCondicion=?,idCategoria=?,idmarca=?,idmedida=? where pSerie=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, p.getpDescripcion());
            pst.setString(2, p.getpObservacion());
            pst.setString(3, p.getDigemi());
            pst.setString(4, p.getpCondicion());
            pst.setInt(5, p.getIdCategoria());
            pst.setInt(6, p.getIdmarca());
            pst.setInt(7, p.getIdmedida());
            pst.setString(8, p.getpSerie());

            rpta = pst.executeLargeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar producto", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarProducto(String serie) {
        boolean rpta = false;
        sql = "delete from producto where pSerie=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, serie);

            rpta = pst.executeLargeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar producto papu ", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarProductoDescripcion(String descripcion) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID_CATE", "ID_MAR", "ID_MED"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, registros);
        sql = "select pSerie,pDescripcion,pObservacion,digemi,pCondicion,caNombre,maNombre,mPresentacion,c.idCategoria,m.idmarca,me.idmedida from producto as p "
                + "inner join marca as m on p.idmarca=m.idmarca "
                + "inner join medida as me on p.idmedida=me.idmedida "
                + "inner join categoria as c on p.idCategoria=c.idCategoria "
                + "where pDescripcion like? limit 0,20";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + descripcion + "%");
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("caNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idCategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");
                
                tabla_temporal.addRow(registros);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar producto por descripcion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }
}
