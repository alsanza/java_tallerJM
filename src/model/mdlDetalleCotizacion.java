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
    public Double totalcotizacion;

    /* Segundo función para mostrar los registros de las tabla empleado */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID","IDcotizacion","Cotización Nro.","Placa","Detalle", "Procedimiento", "Valor", "Porcentaje daño", "cantiad"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[10];

        totalregistros = 0;
        totalcotizacion = 0.0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT d.fk_Id_cotizacion,c.cotizacion_nro,d.IDdetalle_cotizacion,v.placa,s.pieza,s.servicio,s.valor,d.porcentaje_danio,d.cantidad"
                + " FROM detalle_cotizacion d INNER JOIN cotizacion c ON d.fk_id_cotizacion = c.IDcotizacion "
                + "INNER JOIN valor_servicio_pieza s ON d.fk_Id_valor_servicio_pieza = s.IDvalor INNER JOIN vehiculo v ON c.id_vehiculo = v.IDvehiculo "
                + "WHERE c.cotizacion_nro LIKE '%" + buscar + "%' ORDER BY d.fk_id_cotizacion ASC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDdetalle_cotizacion");
                registro[1] = rs.getString("fk_Id_cotizacion");
                registro[2] = rs.getString("cotizacion_nro");
                registro[3] = rs.getString("placa");
                registro[4] = rs.getString("pieza");
                registro[5] = rs.getString("servicio");
                registro[6] = rs.getString("valor");
                registro[7] = rs.getString("porcentaje_danio");
                registro[8] = rs.getString("cantidad");
                registro[9] = rs.getString("pieza");

                totalregistros = totalregistros + 1;
                totalcotizacion = totalcotizacion + (rs.getInt("cantidad") * rs.getDouble("valor"));
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
}
