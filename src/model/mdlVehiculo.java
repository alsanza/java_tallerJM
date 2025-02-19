package model;

import controller.ctrVehiculo;
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
public class mdlVehiculo {

    // Instanciamos la clase Conexion
    private Conexion mysql = new Conexion();
    // Accedemos al métod Connection
    private Connection cn = mysql.conectar();
    //Variables que vamos a utilizar
    private String sSQL = "";// variable que almacena la instrucción SQL
    private String sSQLp = "";//segunda instrucción para la tabla persona
    private String sSQLv = "";
    public Integer totalregistros;

    /* CRUD */
 /* el metodo MOSTRAR devuelve un DefaultTableModel y recibe un parámetro de tipo String que se llama buscar para 
    * buscar un registro en la base de datos, esta consulta devueve todos los registros de la bd
     */
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"IDvehiculo","CÓDIGO","PROPIETARIO","PLACA", "MARCA", "LÍNEA", "MÓDELO", "COLOR"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[8];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT v.IDvehiculo,v.idpropietario,(SELECT nombres FROM persona WHERE IDpersona = v.idpropietario) "
                + "as propietarion,v.placa,v.marca,v.linea,v.modelo,v.color FROM vehiculo v INNER JOIN propietario p"
                + " ON v.idpropietario = p.IDpropietario WHERE v.idpropietario = " + buscar + " ORDER BY v.placa ASC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDvehiculo");
                registro[1] = rs.getString("idpropietario");
                registro[2] = rs.getString("propietarion");
                registro[3] = rs.getString("placa");
                registro[4] = rs.getString("marca");
                registro[5] = rs.getString("linea");
                registro[6] = rs.getString("modelo");
                registro[7] = rs.getString("color");

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
    * CREAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    * lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean insertar(ctrVehiculo fila) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO vehiculo (idpropietario,placa,marca,linea,modelo,color) VALUES (?,?,?,?,?,?)";
        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTRVEHICULO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, fila.getIDpropietario());
            pst.setString(2, fila.getPlaca());
            pst.setString(3, fila.getMarca());
            pst.setString(4, fila.getLinea());
            pst.setString(5, fila.getModelo());
            pst.setString(6, fila.getColor());

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
    * Método para evitar registros duplicadosd
     */
    public boolean registroDuplicado(String placa) {
        boolean respuesta = false;
        sSQL = "SELECT placa FROM vehiculo WHERE placa = '" + placa + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        return respuesta;
    }

    /*
    * MODIFICAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    * lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean editar(ctrVehiculo fila) {
        /* instrucción SQL */
        //String validateSQL = "SELECT COUNT(1) FROM propietario WHERE IDpropietario=?";
        sSQL = "UPDATE vehiculo SET idpropietario=?,placa=?,marca=?,linea=?,modelo=?,color=? WHERE IDvehiculo=?";

        /* Creamos el manejador de errores */
        try {
            // Validar la existencia del propietario 
            //PreparedStatement validatePst = cn.prepareStatement(validateSQL);
            //validatePst.setInt(1, fila.getIDpropietario());
            //ResultSet rs = validatePst.executeQuery();
            
            //if (rs.next() && rs.getInt(1) == 0) {
                // El propietario no existe, lanzar una excepción o manejar el error 
                //throw new SQLException("El propietario con ID " + fila.getIDpropietario() + " no existe.");
            //}
            
             PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, fila.getIDpropietario());
            pst.setString(2, fila.getPlaca());
            pst.setString(3, fila.getMarca());
            pst.setString(4, fila.getLinea());
            pst.setString(5, fila.getModelo());
            pst.setString(6, fila.getColor());
            pst.setInt(7, fila.getIDvehiculo());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {

                return false;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el vehículo: " + e.getMessage());
            return false;
        }
            

           
    }

    /*
    * ELIMINAR, función booleana porque devuelve verdadero o falso que recibe como parámetro la clase del controlador 
    * ctrVehiculo para enviar por el metodo SETTER el id del vehículo. 
    * NOTA: esta función debería validar si existe alguna tarea pendiente relacionada con el vehículo que se va a eliminar
    * ej: una cotización.
     */
    public boolean eliminar(ctrVehiculo fila) {
        /* instrucción SQL */
        String sSQL = "DELETE FROM vehiculo WHERE IDvehiculo=?";

        try (PreparedStatement pst = cn.prepareStatement(sSQL)) {
            pst.setInt(1, fila.getIDvehiculo());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al eliminar el vehículo : " + e.getMessage());
            return false;
        }
    }

}
