package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.ConexionBaseDatos;

public class EjemploJdbc {

	public static void main(String[] args) {

		try (Connection conn = ConexionBaseDatos.getInstance();
				Statement stmt = conn.createStatement();
				ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS")) {
			// OPERAMOS CON LA BASE DE DATOS
			System.out.println("Conectando a la base de datos...");

			try {
				Thread.sleep(2000);
			}

			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (resultado.next()) {
				System.out.print(resultado.getInt("id"));
				System.out.print(" | ");
				System.out.print(resultado.getString("nombre"));
				System.out.print(" | ");
				System.out.print(resultado.getInt("precio"));
				System.out.print(" | ");
				System.out.println(resultado.getDate("fecha_registro"));
			}

		} catch (SQLException e) {
			System.err.println("Error.");
			System.err.println(e.getMessage());
		} finally {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Cerrando conexion.");
		}
	}

}
