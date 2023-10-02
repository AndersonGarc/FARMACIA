package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class ProveedorBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarProveedor() {
        DefaultTableModel modelo;
        String[] titulos = {"RUC", "RAZON_SOCIAL", "REPRESENTANTE", "DIRECCION", "CORREO", "WEB", "CELULAR"};
        String[] registros = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idproveedor,provRazonSocial,provRepresentante,provDireccion,provCorreo,provWeb,provCelular from proveedor";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idproveedor");
                registros[1] = rs.getString("provRazonSocial");
                registros[2] = rs.getString("provRepresentante");
                registros[3] = rs.getString("provDireccion");
                registros[4] = rs.getString("provCorreo");
                registros[5] = rs.getString("provWeb");
                registros[6] = rs.getString("provCelular");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar proveedor BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean registrarProvedor(Proveedor p) {
        boolean rpta = false;
        sql = "insert into proveedor(idproveedor,provRazonSocial,provRepresentante,provDireccion,provCorreo,provWeb,provCelular)values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getIdproveedor());
            pst.setString(2, p.getProvRazonSocial());
            pst.setString(3, p.getProvRepresentante());
            pst.setString(4, p.getProvDireccion());
            pst.setString(5, p.getProvCorreo());
            pst.setString(6, p.getProvWeb());
            pst.setString(7, p.getProvCelular());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar proveedor BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarProveedor(String ruc) {
        DefaultTableModel modelo;
        String[] titulos = {"RUC", "RAZON_SOCIAL", "REPRESENTANTE", "DIRECCION", "CORREO", "WEB", "CELULAR"};
        String[] registros = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idproveedor,provRazonSocial,provRepresentante,provDireccion,provCorreo,provWeb,provCelular from proveedor "
                + "where idproveedor=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                registros[0] = rs.getString("idproveedor");
                registros[1] = rs.getString("provRazonSocial");
                registros[2] = rs.getString("provRepresentante");
                registros[3] = rs.getString("provDireccion");
                registros[4] = rs.getString("provCorreo");
                registros[5] = rs.getString("provWeb");
                registros[6] = rs.getString("provCelular");

                modelo.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar proveedor BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean modificarProveedor(Proveedor p) {
        boolean rpta = false;
        sql = "update proveedor set provRazonSocial=?,provRepresentante=?,provDireccion=?,provCorreo=?,provWeb=?,provCelular=? where idproveedor=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getProvRazonSocial());
            pst.setString(2, p.getProvRepresentante());
            pst.setString(3, p.getProvDireccion());
            pst.setString(4, p.getProvCorreo());
            pst.setString(5, p.getProvWeb());
            pst.setString(6, p.getProvCelular());
            pst.setString(7, p.getIdproveedor());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar proveedor BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarProveedor(String ruc) {
        boolean rpta = false;
        try {
            sql = "delete from proveedor where idproveedor=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);
            
            rpta = pst.executeUpdate() == 1 ? true : false;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar proveedor BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    
    
}
