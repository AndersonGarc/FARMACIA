package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Turno;
import CapaDatos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarUsuarios() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda from usuario as u "
                + "inner join tipousuario as tu on u.tp_idtipoUsuario=tu.idtipoUsuario";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
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
            return tabla_temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public boolean registrarUsuario(Usuario u) {
        boolean rpta = false;
        sql = "insert into usuario(uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tp_idtipoUsuario,tienda)values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuDni());
            pst.setString(2, u.getuNombre());
            pst.setString(3, u.getuApellidos());
            pst.setString(4, u.getuDireccion());
            pst.setString(5, u.getuClave());
            pst.setString(6, u.getuCelular());
            pst.setInt(7, u.getIdtipoUsuario());
            pst.setString(8, u.getTienda());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al registrar", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean modificarUsuario(Usuario u) {
        boolean rpta = false;
        sql = "update usuario set uNombre=?,uApellidos=?,uDireccion=?,uClave=?,uCelular=?,tp_idtipoUsuario=?,tienda=? where uDni=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getuNombre());
            pst.setString(2, u.getuApellidos());
            pst.setString(3, u.getuDireccion());
            pst.setString(4, u.getuClave());
            pst.setString(5, u.getuCelular());
            pst.setInt(6, u.getIdtipoUsuario());
            pst.setString(7, u.getTienda());
            pst.setString(8, u.getuDni());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al modificar");
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarUsuario(String dni) {
        boolean rpta = false;
        sql = "delete from usuario where uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas en el eliminar usuario", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarUsuarioXdni(String dni) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRE", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda from usuario as u "
                + "inner join tipousuario as tu on u.tp_idtipoUsuario=tu.idtipoUsuario "
                + "where uDni=?";
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

    public DefaultTableModel buscarUsuario(String apellidos) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda from usuario as u "
                + "inner join tipousuario as tp on u.tp_idtipoUsuario=tp.idtipoUsuario "
                + "where uApellidos like ? or uNombre like ? limit 0,15";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + apellidos + "%");
            pst.setString(2, "%" + apellidos + "%");
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
            JOptionPane.showMessageDialog(null, e, "EROOR AL BUSCAR USUARIO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public List<Usuario> login(String dni, String clave) {
        List<Usuario> lista = new ArrayList<>();
        sql = "select uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tp_idtipoUsuario,tienda from usuario "
                + "where uDni=? and uClave=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);
            pst.setString(2, clave);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Usuario o_Usuario = new Usuario();

                o_Usuario.setuDni(rs.getString(1));
                o_Usuario.setuNombre(rs.getString(2));
                o_Usuario.setuApellidos(rs.getString(3));
                o_Usuario.setuDireccion(rs.getString(4));
                o_Usuario.setuClave(rs.getString(5));
                o_Usuario.setuCelular(rs.getString(6));
                o_Usuario.setIdtipoUsuario(rs.getInt(7));
                o_Usuario.setTienda(rs.getString(8));

                lista.add(o_Usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error en el login", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public List<Turno> buscarTurno(String inicio, String fin, String u_uDni) {
        List<Turno> lista = new ArrayList<>();
        sql = "select idturno,descripcion,inicio,fin,u_uDni from turno where (inicio<? and fin>?) and u_uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(2, u_uDni);
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
