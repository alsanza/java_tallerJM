package controller;

/**
 * Esta clase extiende de la clase ctrPersona, para poder acceder a sus propiedades
 * 
 */
public class ctrPropietario extends ctrPersona {
    private int IDpropietario;

    public ctrPropietario() {
    }

    public ctrPropietario(int IDpropietario) {
        this.IDpropietario = IDpropietario;
    }

    public int getIDpropietario() {
        return IDpropietario;
    }

    public void setIDpropietario(int IDpropietario) {
        this.IDpropietario = IDpropietario;
    }
    
}
