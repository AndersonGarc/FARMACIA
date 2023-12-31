package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TurnoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTurno() {
        DefaultTableModel modelo;
        String[] titulos = {"CODIGO", "DESCRIPCION", "INICIO", "FIN", "USUARIO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "select idturno,descripcion,inicio,fin,concat(uNombre,' ',uApellidos)as usuario from turno as t "
                + "inner join usuario as u on t.u_uDni=u.uDni";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idturno");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("inicio");
                registros[3] = rs.getString("fin");
                registros[4] = rs.getString("usuario");

                modelo.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Turno BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean registrarTurno(Turno t) {
        boolean rta = false;
        sql = "insert into turno(idturno,descripcion,inicio,fin,u_uDni)values(null,?,?,?,?);";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, t.getDescripcion());
            pst.setString(2, t.getInicio());
            pst.setString(3, t.getFin());
            pst.setString(4, t.getU_uDni());
            rta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al registrar", JOptionPane.ERROR_MESSAGE);
            return rta;
        }
        return rta;
    }

    public boolean eliminarTurno(int idturno) {
        boolean rpta = false;
        sql = "delete from turno where idturno=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idturno);

            rpta = pst.executeLargeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al eliminar", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public List<Turno> buscarTurno(String inicio, String fin, String u_uDni) {
        List<Turno> lista = new ArrayList<>();
        sql = "select idturno,descripcion,inicio,fin,u_uDni from turno where (inicio<? and fin>?) and u_uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(3, u_uDni);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Turno o_Turno = new Turno();

                o_Turno.setIdturno(rs.getInt(1));
                o_Turno.setDescripcion(rs.getString(2));
                o_Turno.setInicio(rs.getString(3));
                o_Turno.setFin(rs.getString(4));
                o_Turno.setU_uDni(rs.getString(5));

                lista.add(o_Turno);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al buscar turno", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
