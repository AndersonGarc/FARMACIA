package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.TipoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoUsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTipoUsuario() {
        DefaultTableModel tabla_temporal;
        String[] cabesera = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        tabla_temporal = new DefaultTableModel(null, cabesera);
        sql = "select idtipoUsuario,tuNombre from tipousuario";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idtipoUsuario");
                registros[1] = rs.getString("tuNombre");
                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar el tipo de usuario", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean registrarTipoUsuario(TipoUsuario tp) {
        sql = "insert into tipousuario(idtipoUsuario,tuNombre) VALUES(null,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tp.getTuNombre());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas en el registrar Cliente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean modificarTipoUsuario(TipoUsuario tp) {
        sql = "update tipousuario set tuNombre=? where idtipoUsuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, tp.getTuNombre());
            pst.setInt(2, tp.getIdtipoUsuario());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas en el modificar tipo de usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean eliminarTipoUsuario(TipoUsuario tp) {
        sql = "insert into tipousuario(idtipoUsuario,tuNombre) VALUES(null,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tp.getTuNombre());

            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas en el registrar Cliente", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
