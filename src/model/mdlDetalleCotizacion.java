package model;

import controller.ctrDetalleCotizacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mdlDetalleCotizacion {

    /*Primero establecemos conexion a la bd*/
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";// variable que almacena la instrucción SQL
    public Integer totalregistros;
    public Integer cantidad;
    public Double valormanoobra;
    public Double valormateriales;
    public Integer valorrepuestos;
    public Double subtotal;
    public Integer iva;
    public Double valoriva;
    public Double totalcotizacion;

    /* Segundo función para mostrar los registros de las tabla empleado */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID", "IDcotizacion", "Cotización Nro.", "IDvehiculo", "Placa", "Detalle", "Procedimiento", "Valor", "Porcentaje daño", "cantiad", "Sub total"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[11];

        totalregistros = 0;
        valormanoobra = 0.0;
        cantidad = 0;
        valormateriales = 0.0;
        valorrepuestos = 0;
        subtotal = 0.0;
        iva = 0;
        valoriva = 0.0;
        totalcotizacion = 0.0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT d.IDdetalle_cotizacion, d.fk_Id_cotizacion, c.IDcotizacion,v.IDvehiculo as IDVehiculo,"
                + "v.placa as placaVehiculo,vsp.pieza as nombrepieza, vsp.servicio as serviciopieza, vsp.valor as valorpieza,"
                + "d.porcentaje_danio, d.cantidad, d.sub_total FROM detalle_cotizacion d INNER JOIN cotizacion c "
                + "ON d.fk_Id_cotizacion = c.IDcotizacion LEFT JOIN vehiculo v ON v.IDvehiculo = d.fk_Id_cotizacion LEFT JOIN "
                + "valor_servicio_pieza vsp ON vsp.IDvalor = d.fk_Id_valor_servicio_pieza "
                + "WHERE c.IDcotizacion = " + buscar + " ORDER BY d.IDdetalle_cotizacion ASC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDdetalle_cotizacion");
                registro[1] = rs.getString("fk_Id_cotizacion");
                registro[2] = rs.getString("IDcotizacion");
                registro[3] = rs.getString("IDVehiculo");
                registro[4] = rs.getString("placaVehiculo");
                registro[5] = rs.getString("nombrepieza");
                registro[6] = rs.getString("serviciopieza");
                registro[7] = rs.getString("valorpieza");
                registro[8] = rs.getString("porcentaje_danio");
                registro[9] = rs.getString("cantidad");
                registro[10] = rs.getString("sub_total");

                totalregistros = totalregistros + 1;
                valormanoobra = valormanoobra + (rs.getDouble("valorpieza") * rs.getDouble("porcentaje_danio") / 100);
                valormateriales = valormateriales + (rs.getDouble("valorpieza") * rs.getDouble("porcentaje_danio") / 100);
                valorrepuestos = valorrepuestos;
                subtotal = subtotal + (valormanoobra + valormateriales + valorrepuestos);
                valoriva = valoriva + ((subtotal * iva) / 100);
                //totalcotizacion = totalcotizacion + ((rs.getDouble("valorpieza") * rs.getDouble("porcentaje_danio")/100) * rs.getInt("cantidad") );
                totalcotizacion = totalcotizacion + (subtotal + valoriva);

                this.CalcularIva(subtotal, iva);
                modelo.addRow(registro);

            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    /* INSERTAR REGISTROS */
    public boolean insertar(ctrDetalleCotizacion dts) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO detalle_cotizacion (fk_Id_cotizacion,fk_Id_valor_servicio_pieza,porcentaje_danio,cantidad,sub_total,total)"
                + "VALUES (?,?,?,?,?,?)";

        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTRDETALLECOTIZACION DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getFk_IDcotizacion());
            pst.setInt(2, dts.getFk_IDvalor_servicio_pieza());
            pst.setDouble(3, dts.getPorcentaje_danio());
            pst.setInt(4, dts.getCantidad());
            pst.setDouble(5, dts.getSubTotal());
            pst.setDouble(6, dts.getTotal());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /* EDITAR REGISTROS RECIBIMO EL CONTROLADOR Y LO LLAMAMOS DTS */
    public boolean editar(ctrDetalleCotizacion dts) {
        /* instrucción SQL */
        sSQL = "UPDATE detalle_cotizacion SET fk_Id_cotizacion =?,fk_Id_valor_servicio_pieza=?,porcentaje_danio=?,cantidad=?,"
                + "sub_total=?,total=? WHERE IDdetalle_cotizacion";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getFk_IDcotizacion());
            pst.setInt(2, dts.getFk_IDvalor_servicio_pieza());
            pst.setDouble(3, dts.getPorcentaje_danio());
            pst.setInt(4, dts.getCantidad());
            pst.setDouble(5, dts.getSubTotal());
            pst.setDouble(6, dts.getTotal());
            pst.setInt(7, dts.getIDdetalle_cotizacion());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {

                return false;

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /* ELIMINAR REGISTROS */
    public boolean eliminar(ctrDetalleCotizacion dts) {
        /* instrucción SQL */
        sSQL = "DELETE FROM detalle_cotizacion WHERE IDdetalle_cotizacion=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIDdetalle_cotizacion());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {

                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    /* METODO PARA CALCULAR EL IVA */
    private double CalcularIva(Double subtotal, int iva) {
        int p_iva = iva;

        //p_iva = valoriva = (subtotal * 0.19);
        switch (p_iva) {

            case 0:
                valoriva = 0.0;
                break;

            case 19:
                valoriva = (subtotal * cantidad) * 0.19;
                break;

            default:
                break;
        }

        return valoriva;
    }
}
