package model;

import controller.ctrVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    * buscar un registro en la base de datos
     */
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"IDvehiculo", "Placa", "Marca", "Linea", "Módelo", "Color","Documento", "Nombres", "Apellidos", "email","Contacto"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[11];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT v.IDvehiculo,e.numero_documento,e.nombres,e.apellidos,e.email,e.contacto,"
                + "e.direccion,v.placa,v.marca,v.linea,v.modelo,v.color FROM vehiculo v"
                + " INNER JOIN propietario p ON v.idpropietario=p.IDpropietario INNER JOIN persona e ON p.IDpropietario=e.IDpersona"
                + " WHERE placa LIKE '%" + buscar + "%' ORDER BY IDvehiculo DESC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDvehiculo");
                registro[1] = rs.getString("placa");
                registro[2] = rs.getString("marca");
                registro[3] = rs.getString("linea");
                registro[4] = rs.getString("modelo");
                registro[5] = rs.getString("color");
                registro[6] = rs.getString("numero_documento");
                registro[7] = rs.getString("nombres");
                registro[8] = rs.getString("apellidos");
                registro[9] = rs.getString("email");
                registro[10] = rs.getString("contacto");
                
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
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
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
    * MODIFICAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    * lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean editar(ctrVehiculo fila) {
        /* instrucción SQL */
       
        sSQL = "UPDATE vehiculo SET placa=?,marca=?,linea=?,modelo=?,color=? WHERE IDvehiculo=?";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            
            pst.setString(1, fila.getPlaca());
            pst.setString(2, fila.getMarca());
            pst.setString(3, fila.getLinea());
            pst.setString(4, fila.getModelo());
            pst.setString(5, fila.getColor());

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
    public boolean eliminar(ctrVehiculo fila) {
        /* instrucción SQL */
        sSQL = "DELETE FROM vehiculo WHERE IDvehiculo=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            

            pst.setInt(1, fila.getIDvehiculo());

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
