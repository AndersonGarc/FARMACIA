package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDER
 */
public class DetalleCompraBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleCompra(DetalleCompra dc) {
        sql = "insert into detallecompra(idcompra,producto_pSerie,,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion) values(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, dc.getIdcompra());
            pst.setString(2, dc.getProducto_pSerie());
            pst.setDouble(3, dc.getDcCantidad());
            pst.setDouble(4, dc.getDcPrecio());
            pst.setDouble(5, dc.getDcImporte());
            pst.setString(6, dc.getDcLote());
            pst.setString(7, dc.getDcPresentacion());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar detalle de compra BD", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
