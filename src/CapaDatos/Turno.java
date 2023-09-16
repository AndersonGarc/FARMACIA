package CapaDatos;

public class Turno {
   private int idturno;
   private String descripcion;
   private String inicio;
   private String fin;
   private String u_uDni;

    public Turno() {
    }

    public Turno(int idturno, String descripcion, String inicio, String fin, String u_uDni) {
        this.idturno = idturno;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.u_uDni = u_uDni;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getU_uDni() {
        return u_uDni;
    }

    public void setU_uDni(String u_uDni) {
        this.u_uDni = u_uDni;
    }
   
   
}
