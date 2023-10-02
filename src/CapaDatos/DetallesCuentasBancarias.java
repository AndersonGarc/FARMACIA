package CapaDatos;

/**
 *
 * @author ANDER
 */
public class DetallesCuentasBancarias {

    private int idcuenta;
    private String banco;
    private String cuenta;
    private String nroCuenta;
    private String idproveedor;

    public DetallesCuentasBancarias() {
    }

    public DetallesCuentasBancarias(int idcuenta, String banco, String cuenta, String nroCuenta, String idproveedor) {
        this.idcuenta = idcuenta;
        this.banco = banco;
        this.cuenta = cuenta;
        this.nroCuenta = nroCuenta;
        this.idproveedor = idproveedor;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

}
