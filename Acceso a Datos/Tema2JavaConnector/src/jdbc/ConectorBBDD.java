package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBBDD {
	private static Connection connect = null;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String BB_URL = "jdbc:mysql://localhost/oposiciones";//Si falla añadir el puerto al final, es el 3306
	static final String USUARIO = "root";
	static final String CONTRA = "";
	
	
	public static Connection conector() throws Exception{
		try {
			Class.forName(JDBC_DRIVER);
			connect = DriverManager.getConnection(BB_URL, USUARIO, CONTRA);
		} catch (Exception e) {
			System.out.println("Error: Clase no encontrada.");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		return connect;
	}
}
