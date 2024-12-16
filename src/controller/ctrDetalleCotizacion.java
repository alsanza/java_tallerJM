
package controller;

/**
 *
 * @author alsan
 */
public class ctrDetalleCotizacion {
    
    private int IDdetalle_cotizacion;
    private int fk_IDcotizacion;
    private int fk_IDvalor_servicio_pieza;
    private double porcentaje_daño;
    private int cantidad;
    private double total;

    public ctrDetalleCotizacion() {
    }

    public ctrDetalleCotizacion(int IDdetalle_cotizacion, int fk_IDcotizacion, int fk_IDvalor_servicio_pieza, double porcentaje_daño, int cantidad, double total) {
        this.IDdetalle_cotizacion = IDdetalle_cotizacion;
        this.fk_IDcotizacion = fk_IDcotizacion;
        this.fk_IDvalor_servicio_pieza = fk_IDvalor_servicio_pieza;
        this.porcentaje_daño = porcentaje_daño;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getIDdetalle_cotizacion() {
        return IDdetalle_cotizacion;
    }

    public void setIDdetalle_cotizacion(int IDdetalle_cotizacion) {
        this.IDdetalle_cotizacion = IDdetalle_cotizacion;
    }

    public int getFk_IDcotizacion() {
        return fk_IDcotizacion;
    }

    public void setFk_IDcotizacion(int fk_IDcotizacion) {
        this.fk_IDcotizacion = fk_IDcotizacion;
    }

    public int getFk_IDvalor_servicio_pieza() {
        return fk_IDvalor_servicio_pieza;
    }

    public void setFk_IDvalor_servicio_pieza(int fk_IDvalor_servicio_pieza) {
        this.fk_IDvalor_servicio_pieza = fk_IDvalor_servicio_pieza;
    }

    public double getPorcentaje_daño() {
        return porcentaje_daño;
    }

    public void setPorcentaje_daño(double porcentaje_daño) {
        this.porcentaje_daño = porcentaje_daño;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
