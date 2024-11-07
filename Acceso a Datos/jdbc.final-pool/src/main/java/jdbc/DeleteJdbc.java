package jdbc;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.util.ConexionBaseDatos;

public class DeleteJdbc {

	public static void main(String[] args) {
		ProductoRepositorioImpl repository = new ProductoRepositorioImpl();
		try (Connection conn = ConexionBaseDatos.getInstance();
				Statement stmt = conn.createStatement();
				ResultSet resultado = stmt.executeQuery("SELECT * FROM PRODUCTOS")) {
			// OPERAMOS CON LA BASE DE DATOS
			System.out.println("Conectando a la base de datos...");

			try {

				Thread.sleep(2000);

			}

			catch (InterruptedException e) {

				System.err.println("Error al hacer la pausa falsa");
				e.printStackTrace();

			}

			System.out.println("LISTADO DE DATOS");
			repository.listar().forEach(System.out::println);

			System.out.println("FILTRADO POR ID");
			System.out.println(repository.porId(3));
			
			if(repository.eliminar(2)) System.out.println("Se ha borrado el registro");
			else System.out.println("No se ha borrado el registro");
			
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
