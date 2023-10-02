package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetallesCuentasBancarias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class DetallesCuentasBancariasBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel buscarDetalleCuentaBancaria(String ruc) {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "BANCO", "CUENTA", "NRO_CUENTA", "RUC"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idcuenta,banco,cuenta,nroCuenta,idproveedor from detallecuentasbancarias "
                + "where idproveedor=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idcuenta");
                registros[1] = rs.getString("banco");
                registros[2] = rs.getString("cuenta");
                registros[3] = rs.getString("nroCuenta");
                registros[4] = rs.getString("idproveedor");

                modelo.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar detalle de cuenta BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean registrarDetalleCuentasBancarias(DetallesCuentasBancarias d) {
        boolean rpta = false;
        sql = "insert into detallecuentasbancarias(idcuenta,banco,cuenta,nroCuenta,idproveedor)values(null,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, d.getBanco());
            pst.setString(2, d.getCuenta());
            pst.setString(3, d.getNroCuenta());
            pst.setString(4, d.getIdproveedor());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar detalle de cuenta BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

        public boolean eliminaarDetalleCuentasBancarias(int idcuenta) {
        boolean rpta = false;
        try {
            sql = "delete from detallecuentasbancarias where idcuenta=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcuenta);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar detalle de cuenta BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
