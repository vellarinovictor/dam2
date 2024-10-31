package prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOperations {
	protected static Statement crearSentencia(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.err.println("No se ha podido crear la sentencia");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
		return null;
	}
	
	public static void crearTabla(Connection connection, String query) {
		Statement sentencia = crearSentencia(connection);
		try {
			sentencia.execute(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la sentencia");
			System.err.println(e.getMessage());
			System.exit(-3);		
		}
	}
	
	public static ResultSet buscarDatos(Connection conn, String query) {
		Statement sentencia = crearSentencia(conn);
		try {
			sentencia.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la consulta");
			System.err.println(e.getMessage());
			return null;	
		}
		try {
			ResultSet resultSet = sentencia.getResultSet();
			return resultSet;
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos de la consulta");
			System.err.println(e.getMessage());
			return null;
		}		
		
	}

	public static PreparedStatement crearSentencia(Connection connection, String query) {
		try {
			return connection.prepareStatement(query);
		} catch (SQLException e) {
			System.err.println("No se ha podido crear la consulta");
			System.err.println(e.getMessage());
			return null;
		}
	}
}
