package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public String db = "tallerjm";
    public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String users = "root";
    public String pass = "";

    public Conexion() {
    }

    /* Funcion para conectar */
    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.users, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

        return link;
    }
}
