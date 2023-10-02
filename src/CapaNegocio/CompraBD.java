    package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
            PreparedStatement pst = cn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

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

}
