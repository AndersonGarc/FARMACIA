package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
import CapaDatos.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDER
 */
public class CategoriaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Categoria> reportarCategoria() {
        List<Categoria> lista = new ArrayList<>();
        sql = "select idCategoria,caNombre from categoria";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Categoria o_Categoria = new Categoria();

                o_Categoria.setIdCategoria(rs.getInt(1));
                o_Categoria.setCaNombre(rs.getString(2));

                lista.add(o_Categoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar categoria", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public boolean registrarCategoria(Categoria m) {
        boolean rpta = false;
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getCaNombre());

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean ModificarCategoria(Categoria m) {
        boolean rpta = false;
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getCaNombre());
            pst.setInt(2,m.getIdCategoria());

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    
    public boolean eliminarCategoria(int idCategoria) {
        boolean rpta = false;
        sql = "delete from categoria where idCategoria=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idCategoria);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar categoria", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
