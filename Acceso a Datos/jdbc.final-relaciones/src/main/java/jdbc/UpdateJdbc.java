package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.util.ConexionBaseDatos;

public class UpdateJdbc {

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

			System.out.println("EDITAR UN PRODUCTO");
			Producto producto = new Producto();
			producto.setId(2);
			producto.setNombre("ASPERSOR");
			producto.setPrecio(34);
			producto.setFecha_registro(new Date());
			Categoria categoria = new Categoria();
			categoria.setId(9L);
			producto.setCategoria(categoria);
			
			if(repository.guardar(producto)) System.out.println("Se ha modificado el Producto");
			else System.out.println("No se ha modificado el producto");
			
			System.out.println("INSERTAR UN PRODUCTO");
			producto = new Producto();
			producto.setNombre("LIBRO DERIVADAS");
			producto.setPrecio(45);
			producto.setFecha_registro(new Date());
			categoria = new Categoria();
			categoria.setId(6L);
			producto.setCategoria(categoria);
			
			if(repository.guardar(producto)) System.out.println("Se ha insertado el producto");
			else System.out.println("No se ha insertado el producto");

			System.out.println("LISTADO DE DATOS");
			repository.listar().forEach(System.out::println);
			
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
