/*
* Se conecta directamente a la base de datos. 
* En esta clase se encuentran las operaciones del CRUD de la tabla empleado.
* Recibe y muestra datos del controlador mediante los métodos SETTER y GETTER
 */
package model;

import controller.ctrEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mdlEmpleado {

    /*Primero establecemos conexion a la bd*/
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";// variable que almacena la instrucción SQL
    private String sSQLt = "";//segunda instrucción para la tabla persona
    public Integer totalregistros;

    /* Segundo función para mostrar los registros de las tabla empleado */
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        /* array string para almacenar los titulos columna de las dos tablas */
        String[] titulos = {"ID", "Tipo documento", "Número documento", "Nombres", "Apellidos", "Email", "Teléfono", "Dirección", "Cargo", "Sueldo", "Usuario", "Estado", "Fecha Registro"};

        /* array string para almacenar los registros de fila */
        String[] registro = new String[13];

        totalregistros = 0;

        modelo = new DefaultTableModel(null, titulos);

        /* instrucción SQL que une las dos tablas con la instruccion INNER JOIN */
        sSQL = "SELECT p.IDpersona,p.tipo_documento,p.numero_documento,p.nombres,p.apellidos,p.email,p.contacto,p.direccion,p.estado,p.fecha_registro,"
                + "t.cargo,t.salario,t.usuario FROM persona p INNER JOIN empleado t ON p.IDpersona=t.IDempleado "
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
                registro[8] = rs.getString("cargo");
                registro[9] = rs.getString("salario");
                registro[10] = rs.getString("usuario");
                registro[11] = rs.getString("estado");
                registro[12] = rs.getString("fecha_registro");

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
    public boolean insertar(ctrEmpleado dts) {
        /* instrucción SQL insertar para la tabla persona */
        sSQL = "INSERT INTO persona (tipo_documento,numero_documento,nombres,apellidos,email,contacto,direccion,estado)"
                + "VALUES (?,?,?,?,?,?,?,1)";
        /* instrucción SQL insertar para la tabla empleado */
        sSQLt = "INSERT INTO empleado (IDempleado,cargo,salario,usuario,password) VALUES ((SELECT IDpersona FROM persona ORDER BY IDpersona DESC LIMIT 1),?,?,?,?)";
        try {
            //REGISTROS SE OBTIENEN DE LA CLASE CTREMPLEADO DEL METODO GET
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pstp = cn.prepareStatement(sSQLt);

            pst.setString(1, dts.getTipo_documento());
            pst.setString(2, dts.getNumero_documento());
            pst.setString(3, dts.getNombres());
            pst.setString(4, dts.getApellidos());
            pst.setString(5, dts.getEmail());
            pst.setString(6, dts.getContacto());
            pst.setString(7, dts.getDireccion());

            //pst.setInt(8, dts.getEstado());
            pstp.setString(1, dts.getCargo());
            pstp.setDouble(2, dts.getSalario());
            pstp.setString(3, dts.getUsuario());
            pstp.setString(4, dts.getPassword());

            int n = pst.executeUpdate();

            if (n != 0) {
                int nc = pstp.executeUpdate();

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

    /* EDITAR REGISTROS RECIBIMO EL CONTROLADOR Y LO LLAMAMOS DTS */
    public boolean editar(ctrEmpleado dts) {
        /* instrucción SQL */
        sSQL = "UPDATE persona SET tipo_documento=?,numero_documento=?,nombres=?,apellidos=?,email=?,contacto=?,direccion=?,estado=? WHERE IDpersona=?";
        sSQLt = "UPDATE empleado SET cargo=?,salario=?,usuario=?,password=? WHERE IDempleado=?";

        /* Creamos el manejador de errores */
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pste = cn.prepareStatement(sSQLt);

            pst.setString(1, dts.getTipo_documento());
            pst.setString(2, dts.getNumero_documento());
            pst.setString(3, dts.getNombres());
            pst.setString(4, dts.getApellidos());
            pst.setString(5, dts.getEmail());
            pst.setString(6, dts.getContacto());
            pst.setString(7, dts.getDireccion());
            pst.setInt(8, dts.getEstado());
            pst.setInt(9, dts.getIDpersona());

            pste.setString(1, dts.getCargo());
            pste.setDouble(2, dts.getSalario());
            pste.setString(3, dts.getUsuario());
            pste.setString(4, dts.getPassword());
            pste.setInt(5, dts.getIDempleado());

            int n = pst.executeUpdate();

            if (n != 0) {

                int nc = pste.executeUpdate();

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

    /* ELIMINAR REGISTROS */
    public boolean eliminar(ctrEmpleado dts) {
        /* instrucción SQL */
        sSQL = "DELETE FROM empleado WHERE IDempleado=?";

        sSQLt = "DELETE FROM persona WHERE IDpersona=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pstp = cn.prepareStatement(sSQLt);

            pst.setInt(1, dts.getIDempleado());
            pstp.setInt(1, dts.getIDpersona());

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

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo= new DefaultTableModel();

        String[] titulos = {"ID", "Nombres", "Apellidos", "Usuario", "password", "estado"};
        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        // Creamos la consulta SQL para traer de la tabla persona el nombre y el apellido y relacionamos con la tabla empelado
        sSQL = "SELECT p.IDpersona,p.nombres,p.apellidos,p.estado,e.usuario,e.password FROM persona p INNER JOIN empleado e" + 
                " ON p.IDpersona=e.IDempleado WHERE e.usuario='"+ login +"' AND e.password='" + password + "' AND p.estado=1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("IDpersona");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("estado");
                
                registro[4] = rs.getString("usuario");
                registro[5] = rs.getString("password");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
}
