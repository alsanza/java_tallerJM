
package controller;

/**
 *
 * @author alsan
 */
public class ctrDetalleCotizacion {
    
    private int IDdetalle_cotizacion;
    private int fk_IDcotizacion;
    private int fk_IDvalor_servicio_pieza;
    private double porcentaje_danio = 0.0;
    private int cantidad = 0;
    private double subTotal = 0.0;
    private double total = 0.0;

    public ctrDetalleCotizacion() {
    }

    public ctrDetalleCotizacion(int IDdetalle_cotizacion, int fk_IDcotizacion, int fk_IDvalor_servicio_pieza, double porcentaje_danio, int cantidad, double subTotal, double total) {
        this.IDdetalle_cotizacion = IDdetalle_cotizacion;
        this.fk_IDcotizacion = fk_IDcotizacion;
        this.fk_IDvalor_servicio_pieza = fk_IDvalor_servicio_pieza;
        this.porcentaje_danio = porcentaje_danio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
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

    public double getPorcentaje_danio() {
        return porcentaje_danio;
    }

    public void setPorcentaje_danio(double porcentaje_danio) {
        this.porcentaje_danio = porcentaje_danio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

        
}
