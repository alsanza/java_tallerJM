package controller;

/**
 *
 * @author alsan
 */
public class ctrPrecioPieza {
    private int idValor;
    private String marca = "";
    private String linea = "";
    private String modelo = "";
    private String pieza = "";
    private String servicio = "";
    private double valor = 0;

    public ctrPrecioPieza() {
    }

    public ctrPrecioPieza(int idValor, String marca, String linea, String modelo, String pieza, String servicio, double valor) {
        this.idValor = idValor;
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.pieza = pieza;
        this.servicio = servicio;
        this.valor = valor;
    }

    public int getIdValor() {
        return idValor;
    }

    public void setIdValor(int idValor) {
        this.idValor = idValor;
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

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza = pieza;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }  
    
    @Override
    public String toString() {
        return this.marca;
    }
    
}
