package model;

import controller.ctrMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class cargarCombo {

    private Conexion mysql = new Conexion();
    private Connection cn = null;

    public List<ctrMarca> mostrarMarca() {
        String sSQL = "SELECT IDmarca, descripcion FROM marca ORDER BY descripcion ASC";
        List<ctrMarca> datos = new ArrayList<>();

        try {
            cn = mysql.conectar();
            PreparedStatement pst = cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();

            ctrMarca mar = new ctrMarca();
            mar.setIDmarca(0);
            mar.setDescripcion("Selecciona una marca");
            datos.add(mar);

            while (rs.next()) {
                mar = new ctrMarca();
                mar.setIDmarca(rs.getInt("IDmarca"));
                mar.setDescripcion(rs.getString("descripcion"));
                datos.add(mar);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener las marcas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return datos;
    }
}


