package model;

import controller.ctrCotizacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author alsan instanciamos en variables privadas los métodos de conexion y
 * las sentencias SQL, y en variables públicas los complementos
 */
public class mdlCotizacion {

    // Instanciamos la clase Conexion
    private Conexion mysql = new Conexion();
    // Accedemos al métod Connection
    private Connection cn = mysql.conectar();
    //Variables que vamos a utilizar
    private String sSQL = "";// variable que almacena la instrucción SQL
    private String sSQLp = "";//segunda instrucción para la tabla persona
    public Integer totalregistros = 0;

    /* CRUD */
 /* el metodo MOSTRAR devuelve un DefaultTableModel y recibe un parámetro de tipo String que se llama buscar para 
    * buscar un registro en la base de datos
     */
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID", "Cotizacón Nro.", "Fecha", "Placa", "Marca", "Linea", "Módelo", "Color","Fecha vencimiento"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[9];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT c.IDcotizacion,c.cotizacion_nro,c.fecha_cotizacion,v.placa,v.marca,v.linea,v.modelo,v.color,"
                + "c.fecha_vencimiento FROM cotizacion c INNER JOIN vehiculo v ON c.id_vehiculo=v.IDvehiculo WHERE"
                + " cotizacion_nro LIKE '%" + buscar + "%' ORDER BY cotizacion_nro ASC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDcotizacion");
                registro[1] = rs.getString("cotizacion_nro");
                registro[2] = rs.getString("fecha_cotizacion");
                registro[3] = rs.getString("placa");
                registro[4] = rs.getString("marca");
                registro[5] = rs.getString("linea");
                registro[6] = rs.getString("modelo");
                registro[7] = rs.getString("color");
                registro[8] = rs.getString("fecha_vencimiento");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }

            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    /*
    *CREAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    *lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean insertar(ctrCotizacion dts) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO cotizacion (cotizacion_nro,fecha_cotizacion,id_vehiculo,fecha_vencimiento)"
                + "VALUES (?,?,?,?)";
        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getCotizacion_nro());
            pst.setDate(2, dts.getFecha_cotizacion());
            pst.setInt(3, dts.getId_vehiculo());
            pst.setDate(4, dts.getFecha_vencimiento());

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

    /*
    * MODIFICAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    * lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean editar(ctrCotizacion dts) {

        /* instrucción SQL */
        sSQL = "UPDATE cotizacion SET cotizacion_nro = ?,fecha_cotizacion = ?,id_vehiculo = ?,fecha_vencimiento = ? WHERE IDcotizacion=?";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getCotizacion_nro());
            pst.setDate(2, dts.getFecha_cotizacion());
            pst.setInt(3, dts.getId_vehiculo());
            pst.setDate(4, dts.getFecha_vencimiento());

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

    /*
    * ELIMINAR, función booleana porque devuelve verdadero o falso que recibe como parámetro la clase del controlador 
    * ctrPropietario lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean eliminar(ctrCotizacion dts) {
        /* instrucción SQL */
        sSQL = "DELETE FROM cotizacion WHERE IDcotizacion=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIDcotizacion());

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

    /*
    * Función para obtener el último ID guardado en la db
    */
    public int obtenerUltimoID() {
        
        int ultimoID = 0;
        
        sSQL = "SELECT MAX(IDcotizacion) FROM cotizacion WHERE IDcotizacion ORDER BY IDcotizacion desc";
        try (
                
                PreparedStatement pst = cn.prepareStatement(sSQL);
                ResultSet rs = pst.executeQuery(sSQL)) {
            
            if (rs.next()) {
                
                ultimoID = rs.getInt(1);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }
        
        return ultimoID;
        
    }

}
