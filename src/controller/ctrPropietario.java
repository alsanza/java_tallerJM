package controller;

/**
 * Esta clase extiende de la clase ctrPersona, para poder acceder a sus propiedades
 * 
 */
public class ctrPropietario extends ctrPersona {
    private int IDpropietario;
    private int cod_propietario = 0;

    public ctrPropietario() {
    }

    public ctrPropietario(int IDpropietario, int cod_propietario) {
        this.IDpropietario = IDpropietario;
        this.cod_propietario = cod_propietario;
    }

    public int getIDpropietario() {
        return IDpropietario;
    }

    public void setIDpropietario(int IDpropietario) {
        this.IDpropietario = IDpropietario;
    }

    public int getCod_propietario() {
        return cod_propietario;
    }

    public void setCod_propietario(int cod_propietario) {
        this.cod_propietario = cod_propietario;
    }
    
}
