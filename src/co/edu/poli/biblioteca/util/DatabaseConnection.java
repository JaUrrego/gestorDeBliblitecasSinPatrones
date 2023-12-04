package co.edu.poli.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection con = null;
	  static
	    {
	        String url = "jdbc:mysql:// localhost:3306/biblioteca_tesis";
	        String user = "root";
	        String pass = "*****"; //modificar contraseña
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	            System.out.println("Conexión a base de datos exitosa!!");
	        }
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }

}
