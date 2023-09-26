package CapaDatos;

/**
 *
 * @author ANDER
 */
    public class Categoria {

    private int idCategoria;
    private String caNombre;

    public Categoria() {
    }

    public Categoria(int idCategoria, String caNombre) {
        this.idCategoria = idCategoria;
        this.caNombre = caNombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCaNombre() {
        return caNombre;
    }

    public void setCaNombre(String caNombre) {
        this.caNombre = caNombre;
    }

}
