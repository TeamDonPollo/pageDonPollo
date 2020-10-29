package util;
import java.sql.*;
public class MySQLConexion_1 {
	public static Connection getConexion(){ 
		Connection con = null;
		try { 
                Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost/polleria"; 
		String usr = "root";
		String psw = ""; 
		con = DriverManager.getConnection(url,usr,psw); 
		System.out.println("conexion ok");
		} catch (ClassNotFoundException ex)
		{ System.out.println("No hay Driver!!"+ex.getMessage()); } 
		catch (SQLException ex) { System.out.println("Error con la BD "); }
		return con; 
		}
}

