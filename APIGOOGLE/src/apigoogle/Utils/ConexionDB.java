package apigoogle.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionDB {
	
	//Cambiar estos campos con las credenciales.
	private String url = "authordatabase";
	private static String username = "root";
	private static String password = "22081997";

	
		
    private Connection conexion;
    
    
    public static void createDataBase() {
    	
    	try {
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", username, password);
    		Statement statement = connection.createStatement();
    		statement.execute("CREATE DATABASE IF NOT EXISTS authordatabase;");
    		connection.close();
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public static void vaciarTablas() {
    	try {
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authordatabase", username, password);
    		Statement stmt = conn.createStatement();
    		String sql = "DELETE FROM author;";
    		stmt.execute(sql);
    		conn.close();

    	}
    	catch (Exception e) {
    		
    	}
    }
    
    public static void generarTablas() {
    	try {
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authordatabase", username, password);
    		Statement stmt = conn.createStatement();
    		String sql = "CREATE TABLE IF NOT EXISTS `author` ( "
    				+ "`id` int NOT NULL AUTO_INCREMENT, "
    				+ "`author_id` varchar(999) DEFAULT NULL, "
    		        + "`name` varchar(999) DEFAULT NULL, "
    		        + "`affiliations` varchar(999) DEFAULT NULL, "
    		        + "`cited_by` int DEFAULT NULL, "
    		        + "PRIMARY KEY (`id`) "
    		        + ") ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

    		stmt.execute(sql);
    		conn.close();

    	}
    	catch (Exception e) {
    		
    	}
    }
    
    
    public ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ url , username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
