package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TurnoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTurno() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"CODIGO", "DESCRIPCION", "INICIO", "FIN", "USUARIO"};
        String[] registros = new String[5];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,idtipoUsuario,tienda from usuario as u \n"
                + "inner join tipousuario as tu on u.tp_idtipoUsuario=tu.idtipoUsuario";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idturno");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("inicio");
                registros[3] = rs.getString("fin");
                registros[4] = rs.getString("u_uDni");

                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Turno BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public DefaultTableModel buscarUsuarioXdni(String dni) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRE", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");
                tabla_temporal.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar Turno BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;

    }

    public boolean registrarTurno(Turno t) {
        boolean rta = false;
        sql = "";
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
        sql = "";
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
}
