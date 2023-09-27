/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Composicion;
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
public class ComposicionBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Composicion> reportarComposicion() {
        List<Composicion> lista = new ArrayList<>();
        sql = "select idcomposicion,coNombre,pSerie from composicion order by idcomposicion asc";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                        
            while (rs.next()) {
                Composicion o_Composicion = new Composicion();

                o_Composicion.setIdcomposicion(rs.getInt(1));
                o_Composicion.setCoNombre(rs.getString(2));
                o_Composicion.setpSerie(rs.getString(3));

                lista.add(o_Composicion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar composicion", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public boolean registrarComposicion(Composicion c) {
        boolean rpta = false;
        sql = "insert into composicion(idcomposicion,coNombre,pSerie)values(null,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, c.getCoNombre());
            pst.setString(2, c.getpSerie());
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar composicion", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarComposicion(int idcomposicion) {
        boolean rpta = false;
        sql = "delete from composicion where idcomposicion=?";
        try {
            PreparedStatement pst =cn.prepareStatement(sql);
            pst.setInt(1, idcomposicion);
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar composicion", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }
}
