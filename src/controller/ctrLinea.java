package controller;

/**
 *
 * @author alsan
 */
public class ctrLinea {

    private int IDlinea_vehiculo;
    private int IDmarca;
    private String descripcion;

    public ctrLinea() {
    }

    public ctrLinea(int IDlinea_vehiculo, int IDmarca, String descripcion) {
        this.IDlinea_vehiculo = IDlinea_vehiculo;
        this.IDmarca = IDmarca;
        this.descripcion = descripcion;
    }

    public int getIDlinea_vehiculo() {
        return IDlinea_vehiculo;
    }

    public void setIDlinea_vehiculo(int IDlinea_vehiculo) {
        this.IDlinea_vehiculo = IDlinea_vehiculo;
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
        return this.descripcion;
    }
    
}
