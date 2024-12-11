package controller;

/**
 *
 * @author alsan
 */
public class ctrLinea {

    private int IDlinea_vehiculo;
    private int IDmarca;
    private String desc_linea;

    public ctrLinea() {
    }

    public ctrLinea(int IDlinea_vehiculo, int IDmarca, String desc_linea) {
        this.IDlinea_vehiculo = IDlinea_vehiculo;
        this.IDmarca = IDmarca;
        this.desc_linea = desc_linea;
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
        return desc_linea;
    }

    public void setDescripcion(String desc_linea) {
        this.desc_linea = desc_linea;
    }
    
    @Override
    public String toString() {
        return this.desc_linea;
    }
    
}
