package model;

import controller.ctrPrecioPieza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mdlPrecioPorPieza {

    /*Primero establecemos conexion a la bd*/
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";// variable que almacena la instrucción SQL
    public Integer totalregistros;

    /* Segundo función para mostrar los registros de las tabla empleado */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID", "Marca", "Línea", "Módelo", "Pieza", "Servicio", "Valor", "Fecha registro"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[8];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT * FROM valor_servicio_pieza WHERE IDvalor LIKE '%" + buscar + "%' ORDER BY marca ASC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDvalor");
                registro[1] = rs.getString("marca");
                registro[2] = rs.getString("linea_vehiculo");
                registro[3] = rs.getString("modelo");
                registro[4] = rs.getString("pieza");
                registro[5] = rs.getString("servicio");
                registro[6] = rs.getString("valor");
                registro[7] = rs.getString("fecha_registro");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    /* INSERTAR REGISTROS */
    public boolean insertar(ctrPrecioPieza dts) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO valor_servicio_pieza (marca,linea_vehiculo,modelo,pieza,servicio,valor)"
                + "VALUES (?,?,?,?,?,?)";

        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getMarca());
            pst.setString(2, dts.getLinea());
            pst.setString(3, dts.getModelo());
            pst.setString(4, dts.getPieza());
            pst.setString(5, dts.getServicio());
            pst.setDouble(6, dts.getValor());

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
    public boolean editar(ctrPrecioPieza dts) {
        /* instrucción SQL */
        sSQL = "UPDATE valor_servicio_pieza SET marca=?,linea_vehiculo=?,modelo=?,pieza=?,servicio=?,valor=? WHERE IDvalor=?";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getMarca());
            pst.setString(2, dts.getLinea());
            pst.setString(3, dts.getModelo());
            pst.setString(4, dts.getPieza());
            pst.setString(5, dts.getServicio());
            pst.setDouble(6, dts.getValor());
            pst.setInt(7, dts.getIdValor());

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
    public boolean eliminar(ctrPrecioPieza dts) {
        /* instrucción SQL */
        sSQL = "DELETE FROM valor_servicio_pieza WHERE IDvalor=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdValor());

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
