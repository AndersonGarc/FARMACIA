package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANDER
 */
public class MedidaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarMedida() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "PRESENTACION", "EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idmedida,mPresentacion,mEquivalencia from medida";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");
                modelo.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar medida BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean registrarMedida(Medida m) {
        boolean rpta = false;
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar medida", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean registraMedida(Medida m) {
        sql = "insert into medida(idmedida,mPresentacion,mEquivalencia)values(0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public boolean modicarMedida(Medida m) {
        sql = "update medida set mPresentacion=?,mEquivalencia=? where idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            pst.setInt(3, m.getIdmedida());     
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean eliminarMedida(int idmedida){
        sql="delete from medida where idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idmedida);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Error al eliminar",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
