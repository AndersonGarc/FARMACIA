package CapaDatos;

public class TipoUsuario {

    private int idtipoUsuario;
    private String tuNombre;

    public TipoUsuario() {
    }

    public TipoUsuario(int idtipoUsuario, String tuNombre) {
        this.idtipoUsuario = idtipoUsuario;
        this.tuNombre = tuNombre;
    }

    public int getIdtipoUsuario() {
        return idtipoUsuario;
    }

    public void setIdtipoUsuario(int idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

    public String getTuNombre() {
        return tuNombre;
    }

    public void setTuNombre(String tuNombre) {
        this.tuNombre = tuNombre;
    }

}
