package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class DetalleCompraBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleCompra(DetalleCompra dc) {
        sql = "insert into detallecompra(compra_idcompra,producto_pSerie,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dc.getIdcompra());
            pst.setString(2, dc.getProducto_pSerie());
            pst.setDouble(3, dc.getDcCantidad());
            pst.setDouble(4, dc.getDcPrecio());
            pst.setDouble(5, dc.getDcImporte());
            pst.setString(6, dc.getDcLote());
            pst.setString(7, dc.getDcPresentacion());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar detalle de compra BD", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public DefaultTableModel buscarDetalleCompra(int idcompra) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "SERIE", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE", "LOTE", "PRESENTACION"};
        String[] registros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select compra_idcompra,producto_pSerie,pDescripcion,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion from detallecompra as dc "
                + "inner join producto as p on dc.producto_pSerie=p.pSerie "
                + "where compra_idcompra=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("compra_idcompra");
                registros[1] = rs.getString("producto_pSerie");
                registros[2] = rs.getString("pDescripcion");
                registros[3] = rs.getString("dcCantidad");
                registros[4] = rs.getString("dcPrecio");
                registros[5] = rs.getString("dcImporte");
                registros[6] = rs.getString("dcLote");
                registros[7] = rs.getString("dcPresentacion");

                modelo.addRow(registros);
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar detalle de compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean eliminarCompraXfecha(int idcompra) {
        boolean rpta = false;
        try {
            sql = "delete from detallecompra where compra_idcompra=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar detalle compra BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
