package CapaDatos;

public class Usuario {

    private String uDni;
    private String uNombre;
    private String uApellidos;
    private String uDireccion;
    private String uClave;
    private String uCelular;
    private String tienda;
    private int idtipoUsuario;

    public Usuario() {
    }

    public Usuario(String uDni, String uNombre, String uApellidos, String uDireccion, String uClave, String uCelular, String tienda, int idtipoUsuario) {
        this.uDni = uDni;
        this.uNombre = uNombre;
        this.uApellidos = uApellidos;
        this.uDireccion = uDireccion;
        this.uClave = uClave;
        this.uCelular = uCelular;
        this.tienda = tienda;
        this.idtipoUsuario = idtipoUsuario;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getuNombre() {
        return uNombre;
    }

    public void setuNombre(String uNombre) {
        this.uNombre = uNombre;
    }

    public String getuApellidos() {
        return uApellidos;
    }

    public void setuApellidos(String uApellidos) {
        this.uApellidos = uApellidos;
    }

    public String getuDireccion() {
        return uDireccion;
    }

    public void setuDireccion(String uDireccion) {
        this.uDireccion = uDireccion;
    }

    public String getuClave() {
        return uClave;
    }

    public void setuClave(String uClave) {
        this.uClave = uClave;
    }

    public String getuCelular() {
        return uCelular;
    }

    public void setuCelular(String uCelular) {
        this.uCelular = uCelular;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public int getIdtipoUsuario() {
        return idtipoUsuario;
    }

    public void setIdtipoUsuario(int idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

}
