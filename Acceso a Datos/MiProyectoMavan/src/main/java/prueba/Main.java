package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import prueba.repositories.JDBCOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Conexión a jdbc con Maven!");
		String urlMysql = "jdbc:mysql://localhost/censoJerez";
		String username = "root";
		String password = "";
		System.out.println("Conectando al servidor...");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);
		
		System.out.println("Conectado a la base de datos.");
		String crearTablaPersonas = "CREATE TABLE IF NOT EXISTS PERSONAS("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "nombre VARCHAR(30) NOT NULL,"
				+ "password VARCHAR(30) NOT NULL,"
				+ "telefono VARCHAR(9) NOT NULL"
				+ ");";
		String crearTablaDirecciones = "CREATE TABLE IF NOT EXISTS DIRECCIONES("
				+ "id INTEGER PRIMARY KEY AUTO_INCREMENT,"
				+ "persona_id INTEGER NOT NULL,"
				+ "direccion VARCHAR(50) NOT NULL,"
				+ "FOREIGN KEY (persona_id) REFERENCES personas(id));";
		
		String buscarPersona = "SELECT * FROM PERSONAS WHERE ID = 1";
		
		//JDBCOperations.crearTabla(connection, crearTablaPersonas);
		
		//JDBCOperations.crearTabla(connection, crearTablaDirecciones);
		
		ResultSet resultSet = JDBCOperations.buscarDatos(connection, buscarPersona);
		if(resultSet!=null) {
			try {
				while (resultSet.isLast()) {
					resultSet.next();
					System.out.printf("DI: %d\tNombre: %s\t",resultSet.getInt(1),resultSet.getString(2));
				}
			} catch (SQLException e) {
				System.err.println("No se ha podido ejecutar la sentencia");
				System.err.println(e.getMessage());
				System.exit(-5);	
				}
			
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Cerrando la conexión con el servido SGBD.");
	}

}
