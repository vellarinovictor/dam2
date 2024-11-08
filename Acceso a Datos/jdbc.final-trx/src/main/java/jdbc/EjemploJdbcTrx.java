package jdbc;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.repositorio.ProductoRepositorioImpl;
import jdbc.util.ConexionBaseDatos;

public class EjemploJdbcTrx {

	public static void main(String[] args) {
		ProductoRepositorioImpl repository = new ProductoRepositorioImpl();
		try (Connection conn = ConexionBaseDatos.getInstance()) {
			// OPERAMOS CON LA BASE DE DATOS
			System.out.println("Conectando a la base de datos...");

			if (conn.getAutoCommit())// Ponemos el autocommit a false.
				conn.setAutoCommit(false);// INICIAMOS LA TRANSACCION

			Categoria categoria;
			Producto producto;
			try {

				System.out.println("LISTADO DE DATOS");
				repository.listar().forEach(System.out::println);

//			System.out.println("FILTRADO POR ID");
//			System.out.println(repository.porId(3));

				System.out.println("EDITAR UN PRODUCTO");
				producto = new Producto();
				producto.setId(2L);
				producto.setNombre("ASPERSOR");
				producto.setPrecio(34);
				producto.setFecha_registro(new Date());
				producto.setSku("321zyx");

				categoria = new Categoria();
				categoria.setId(9L);
				producto.setCategoria(categoria);

				if (repository.guardar(producto))
					System.out.println("Se ha modificado el Producto");
				else
					System.out.println("No se ha modificado el producto");

				System.out.println("INSERTAR UN PRODUCTO");
				producto = new Producto();
				producto.setNombre("LIBRO DERIVADAS");
				producto.setPrecio(45);
				producto.setFecha_registro(new Date());
				producto.setSku("123abc");
				categoria = new Categoria();
				categoria.setId(6L);
				producto.setCategoria(categoria);

				if (repository.guardar(producto))
					System.out.println("Se ha insertado el producto");
				else
					System.out.println("No se ha insertado el producto");

				System.out.println("LISTADO DE DATOS");
				repository.listar().forEach(System.out::println);

				// Si todo se ejecuta con exito, se cierra la transaccion
				conn.commit();

			} catch (SQLException e) {
				System.err.println("Error. Hacemos rollback");
				conn.rollback();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
