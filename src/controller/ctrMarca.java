package controller;

public class ctrMarca {
    private int IDmarca;
    private String descripcion = "";

    public ctrMarca() {
    }

    public ctrMarca(int IDmarca, String descripcion) {
        this.IDmarca = IDmarca;
        this.descripcion = descripcion;
    }

    public int getIDmarca() {
        return IDmarca;
    }

    public void setIDmarca(int IDmarca) {
        this.IDmarca = IDmarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}

