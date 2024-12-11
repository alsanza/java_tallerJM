package controller;

import java.sql.Date;

/**
 *
 * @author alsan
 */
public class ctrCotizacion {
    private int IDcotizacion;
    private int cotizacion_nro;
    private Date fecha_cotizacion;
    private int id_vehiculo;
    private Date fecha_vencimiento;

    public ctrCotizacion() {
    }

    public ctrCotizacion(int IDcotizacion, int cotizacion_nro, Date fecha_cotizacion, int id_vehiculo, Date fecha_vencimiento) {
        this.IDcotizacion = IDcotizacion;
        this.cotizacion_nro = cotizacion_nro;
        this.fecha_cotizacion = fecha_cotizacion;
        this.id_vehiculo = id_vehiculo;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getIDcotizacion() {
        return IDcotizacion;
    }

    public void setIDcotizacion(int IDcotizacion) {
        this.IDcotizacion = IDcotizacion;
    }

    public int getCotizacion_nro() {
        return cotizacion_nro;
    }

    public void setCotizacion_nro(int cotizacion_nro) {
        this.cotizacion_nro = cotizacion_nro;
    }

    public Date getFecha_cotizacion() {
        return fecha_cotizacion;
    }

    public void setFecha_cotizacion(Date fecha_cotizacion) {
        this.fecha_cotizacion = fecha_cotizacion;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
}
