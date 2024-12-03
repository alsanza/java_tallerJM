package model;

import controller.ctrMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alsan
 */
public class mdlDatosMarca {

    // Instanciamos la clase Conexion
    private Conexion mysql = new Conexion();
    // Accedemos al métod Connection
    private Connection cn = mysql.conectar();
    //Variables que vamos a utilizar
    private String sSQL = "";// variable que almacena la instrucción SQL
    public Integer totalregistros;

    
    /*
    * Función para rellenar los combos del formulario
    
    public void PasarDatoCombo(String tabla, String valor, JComboBox combo) {
        
        String busqueda_marca = "";
        
        String sSQL = "SELECT * FROM " + tabla;// variable que almacena la instrucción SQL

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }*/
    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID", "Descripción"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[2];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT * FROM marca WHERE descripcion LIKE '%" + buscar + "%' ORDER BY IDmarca ASC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            /* recorrer los registros de la tabla */
            while (rs.next()) {
                registro[0] = rs.getString("IDmarca");
                registro[1] = rs.getString("descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }finally {
            // Cerrar los recursos 
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /*
    * CREAR, función booleana porque devuelve verdadero o falso que recibe la clase del controlador ctrPropietario
    * lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean insertar(ctrMarca fila) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO marca (descripcion) VALUES (?)";

        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, fila.getDescripcion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } finally {
            // Cerrar los recursos 
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public boolean editar(ctrMarca fila) {
        /* instrucción SQL */
        sSQL = "UPDATE marca SET descripcion=? WHERE IDmarca=?";

        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, fila.getDescripcion());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally {
            // Cerrar los recursos 
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /*
    * ELIMINAR, función booleana porque devuelve verdadero o falso que recibe como parámetro la clase del controlador 
    * ctrPropietario lleva dos sentencias SQL, para la tabla persona y otra para la tabla propietario
     */
    public boolean eliminar(ctrMarca fila) {
        /* instrucción SQL */
        sSQL = "DELETE FROM marca WHERE IDmarca=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, fila.getIDmarca());

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
        }finally {
            // Cerrar los recursos 
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
