package controller;

/**
 *
 * @author alsan
 */
public class ctrVehiculo extends ctrPropietario {
    private int IDvehiculo;
    private int idpropietario;
    private String placa;
    private String marca;
    private String linea;
    private String modelo;
    private String color;

    public ctrVehiculo() {
    }

    public ctrVehiculo(int IDvehiculo, int idpropietario, String placa, String marca, String linea, String modelo, String color) {
        this.IDvehiculo = IDvehiculo;
        this.idpropietario = idpropietario;
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.color = color;
    }

    public int getIDvehiculo() {
        return IDvehiculo;
    }

    public void setIDvehiculo(int IDvehiculo) {
        this.IDvehiculo = IDvehiculo;
    }

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
