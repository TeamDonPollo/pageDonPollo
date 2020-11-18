package util;

import java.sql.*;

public class MySQLConexion {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://mysql5030.site4now.net/db_a6978f_prueba";
            String usr = "a6978f_prueba";
            String psw = "prueba123";
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("conexion ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay Driver!!");
        } catch (SQLException ex) {
            System.out.println("Error con la BD ");
        }
        return con;
    }
}
