package controller;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author alsan
 */
public class ctrCotizacion {
    private int IDcotizacion;
    private int cotizacion_nro = 0;
    private Date fecha_cotizacion;
    private int id_vehiculo = 0;
    private Double valor_cotizacion = 0.0;
    private Date fecha_vencimiento;
    private int estado = 0;

    public ctrCotizacion() {
    }
    
    // CONSTRUCTOR SOBRECARGADO

    public ctrCotizacion(int IDcotizacion, int cotizacion_nro, Date fecha_cotizacion, int id_vehiculo, Double valor_cotizacion, Date fecha_vencimiento, int estado) {
        this.IDcotizacion = IDcotizacion;
        this.cotizacion_nro = cotizacion_nro;
        this.fecha_cotizacion = fecha_cotizacion;
        this.id_vehiculo = id_vehiculo;
        this.valor_cotizacion = valor_cotizacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
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

    public Double getValor_cotizacion() {
        return valor_cotizacion;
    }

    public void setValor_cotizacion(Double valor_cotizacion) {
        this.valor_cotizacion = valor_cotizacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    @Override
    public String toString() {
        return "ctrCotizacion{" + "IDcotizacion=" + IDcotizacion + ", cotizacion_nro=" + cotizacion_nro + ", fecha_cotizacion=" + fecha_cotizacion + ", id_vehiculo=" + id_vehiculo + ", valor_cotizacion=" + valor_cotizacion + ", fecha_vencimiento=" + fecha_vencimiento + ", estado=" + estado + '}';
    }
    
}
