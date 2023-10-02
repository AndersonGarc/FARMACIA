package CapaDatos;

/**
 *
 * @author ANDER
 */
public class Proveedor {

    private String idproveedor;
    private String provRazonSocial;
    private String provRepresentante;
    private String provDireccion;
    private String provCorreo;
    private String provWeb;
    private String provCelular;

    public Proveedor() {
    }

    public Proveedor(String idproveedor, String provRazonSocial, String provRepresentante, String provDireccion, String provCorreo, String provWeb, String provCelular) {
        this.idproveedor = idproveedor;
        this.provRazonSocial = provRazonSocial;
        this.provRepresentante = provRepresentante;
        this.provDireccion = provDireccion;
        this.provCorreo = provCorreo;
        this.provWeb = provWeb;
        this.provCelular = provCelular;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getProvRazonSocial() {
        return provRazonSocial;
    }

    public void setProvRazonSocial(String provRazonSocial) {
        this.provRazonSocial = provRazonSocial;
    }

    public String getProvRepresentante() {
        return provRepresentante;
    }

    public void setProvRepresentante(String provRepresentante) {
        this.provRepresentante = provRepresentante;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public String getProvCorreo() {
        return provCorreo;
    }

    public void setProvCorreo(String provCorreo) {
        this.provCorreo = provCorreo;
    }

    public String getProvWeb() {
        return provWeb;
    }

    public void setProvWeb(String provWeb) {
        this.provWeb = provWeb;
    }

    public String getProvCelular() {
        return provCelular;
    }

    public void setProvCelular(String provCelular) {
        this.provCelular = provCelular;
    }

}
