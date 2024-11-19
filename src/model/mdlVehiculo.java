package model;

import controller.ctrPropietario;
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
        String[] titulos = {"ID", "Tipo documento", "Número documento", "Nombres", "Apellidos", "Email", "Teléfono", "Dirección"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[8];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT p.IDpersona,p.tipo_documento,p.numero_documento,p.nombres,p.apellidos,p.email,p.contacto,p.direccion,p.estado,"
                + "p.fecha_registro FROM persona p INNER JOIN propietario t ON p.IDpersona=t.IDpropietario "
                + "WHERE numero_documento LIKE '%" + buscar + "%' ORDER BY IDpersona DESC";

        /* Capturador de errores */
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDpersona");
                registro[1] = rs.getString("tipo_documento");
                registro[2] = rs.getString("numero_documento");
                registro[3] = rs.getString("nombres");
                registro[4] = rs.getString("apellidos");
                registro[5] = rs.getString("email");
                registro[6] = rs.getString("contacto");
                registro[7] = rs.getString("direccion");

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
        sSQL = "INSERT INTO persona (tipo_documento,numero_documento,nombres,apellidos,email,contacto,direccion,estado)"
                + "VALUES (?,?,?,?,?,?,?,1)";
        /* instrucción SQL insertar para la tabla empleado */
        sSQLp = "INSERT INTO propietario (IDpropietario) VALUES ((SELECT IDpersona FROM persona ORDER BY IDpersona DESC LIMIT 1))";

        sSQLv = "INSERT INTO vehiculo (idpropietario,placa,marca,linea,modelo,color) VALUES ((SELECT IDpropietario FROM propietario ORDER BY IDpropietario DESC LIMIT 1),?,?,?,?,?)";
        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pstp = cn.prepareStatement(sSQLp);
            PreparedStatement pstv = cn.prepareStatement(sSQLv);

            pst.setString(1, fila.getTipo_documento());
            pst.setString(2, fila.getNumero_documento());
            pst.setString(3, fila.getNombres());
            pst.setString(4, fila.getApellidos());
            pst.setString(5, fila.getEmail());
            pst.setString(6, fila.getContacto());
            pst.setString(7, fila.getDireccion());

            pstv.setString(1, fila.getPlaca());
            pstv.setString(2, fila.getMarca());
            pstv.setString(3, fila.getLinea());
            pstv.setString(4, fila.getModelo());
            pstv.setString(5, fila.getColor());

            int n = pst.executeUpdate();

            if (n != 0) {
                int nc = pstp.executeUpdate();

                if (nc != 0) {

                    int nv = pstv.executeUpdate();

                    if (nv != 0) {
                        
                        return true;
                        
                    } else {
                        
                        return false;
                    }
                } else {
                    return false;
                }
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
        sSQL = "UPDATE persona SET tipo_documento=?,numero_documento=?,nombres=?,apellidos=?,email=?,contacto=?,direccion=?,estado=? WHERE IDpersona=?";
        sSQLp = "UPDATE propietario SET  WHERE IDpropietario=?";
        sSQLv = "UPDATE vehiculo SET placa=?,marca=?,linea=?,modelo=?,color=? WHERE IDvehiculo=?";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pstp = cn.prepareStatement(sSQLp);
            PreparedStatement pstv = cn.prepareStatement(sSQLv);

            pst.setString(1, fila.getTipo_documento());
            pst.setString(2, fila.getNumero_documento());
            pst.setString(3, fila.getNombres());
            pst.setString(4, fila.getApellidos());
            pst.setString(5, fila.getEmail());
            pst.setString(6, fila.getContacto());
            pst.setString(7, fila.getDireccion());
            pst.setInt(8, fila.getEstado());
            pst.setInt(9, fila.getIDpersona());

            pstv.setString(1, fila.getPlaca());
            pstv.setString(2, fila.getMarca());
            pstv.setString(3, fila.getLinea());
            pstv.setString(4, fila.getModelo());
            pstv.setString(5, fila.getColor());

            int n = pst.executeUpdate();

               if (n != 0) {
                int nc = pstp.executeUpdate();

                if (nc != 0) {

                    int nv = pstv.executeUpdate();

                    if (nv != 0) {
                        
                        return true;
                        
                    } else {
                        
                        return false;
                    }
                } else {
                    return false;
                }
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
        sSQL = "DELETE FROM empleado WHERE IDempleado=?";

        sSQLp = "DELETE FROM persona WHERE IDpersona=?";

        sSQLv = "DELETE FROM vehiculo WHERE IDvehiculo=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pstp = cn.prepareStatement(sSQLp);
            PreparedStatement pstv = cn.prepareStatement(sSQLv);

            pst.setInt(1, fila.getIDpropietario());
            pstp.setInt(1, fila.getIDpersona());
            pstv.setInt(1, fila.getIDpersona());

            int n = pst.executeUpdate();

            if (n != 0) {
                int nc = pst.executeUpdate();

                if (nc != 0) {

                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

}
