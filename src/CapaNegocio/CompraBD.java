package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class CompraBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public int registrarCompra(Compra c) {
        int idventa = 0;
        sql = "insert into compra(idcompra,coFecha,coTipoDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,proveedor_idproveedor,uDni,tienda)                           "
                + "values(0,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, c.getCoFecha());
            pst.setString(2, c.getCoTipoDoc());
            pst.setString(3, c.getCoNroDoc());
            pst.setString(4, c.getCoTipoPago());
            pst.setString(5, c.getCoFormaPago());
            pst.setString(6, c.getCoMoneda());
            pst.setDouble(7, c.getCoSubTotal());
            pst.setDouble(8, c.getCoFlete());
            pst.setDouble(9, c.getCoIgv());
            pst.setDouble(10, c.getCoTotal());
            pst.setString(11, c.getProveedor_idproveedor());
            pst.setString(12, c.getuDni());
            pst.setString(13, c.getTienda());

            pst.executeUpdate();
            ResultSet resultado = pst.getGeneratedKeys();

            if (resultado.next()) {
                idventa = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar compra BD", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return idventa;
    }

    public DefaultTableModel reporteCompraFecha(String fechaInicio, String fechaFinal) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "FECHA", "PROVEEDOR", "TIPO_DOC", "NRO_DOC", "TIPO_PAGO", "FORMA_PAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.proveedor_idproveedor,c.uDni,tienda from compra as c "
                + "inner join proveedor as p on c.proveedor_idproveedor=p.idproveedor "
                + "where coFecha between ? and ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("proveedor_idproveedor");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public DefaultTableModel reporteCompraXdocumento(String fechaInicio, String fechaFinal, String documento) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "FECHA", "PROVEEDOR", "TIPO_DOC", "NRO_DOC", "TIPO_PAGO", "FORMA_PAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.proveedor_idproveedor,c.uDni,tienda from compra as c "
                + "inner join proveedor as p on c.proveedor_idproveedor=p.idproveedor "
                + "where (coFecha between ? and ?) and coTipoDoc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, documento);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("proveedor_idproveedor");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public DefaultTableModel reporteCompraXproveedor(String fechaInicio, String fechaFinal, String proveedor) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "FECHA", "PROVEEDOR", "TIPO_DOC", "NRO_DOC", "TIPO_PAGO", "FORMA_PAGO", "MONEDA", "SUBTOTAL", "FLETE", "IGV", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idcompra,coFecha,provRazonSocial,coTipoDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.proveedor_idproveedor,c.uDni,tienda from compra as c "
                + "inner join proveedor as p on c.proveedor_idproveedor=p.idproveedor "
                + "where (coFecha between ? and ?) and provRazonSocial=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, proveedor);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idcompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipoDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("proveedor_idproveedor");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar por proveedor compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean eliminarCompra(int idcompra) {
        boolean rpta = false;
        try {
            sql = "delete from compra where idcompra=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar compra BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
