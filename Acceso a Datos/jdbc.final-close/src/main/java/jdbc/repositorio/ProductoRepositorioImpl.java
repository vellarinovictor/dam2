package jdbc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
	private static Connection getConnection() throws SQLException {
		return ConexionBaseDatos.getInstance();
	}

	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<Producto>();
		try (Connection conn = getConnection();
			Statement stm = conn.createStatement()) {
			ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCTOS");
			while (rs.next()) {
				Producto p = new Producto(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4));
				System.out.println(p);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return productos;
	}

	@Override
	public Producto porId(long id) {
		Producto producto = null;
		try(Connection conn = getConnection();
			 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCTOS WHERE ID = ?")) {
			 stmt.setLong(1, id);
			 try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Producto(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getDate(4));
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean guardar(Producto producto) {
		String sql;
		//VAMOS A APROVECHAR PARA GUARDAR Y ACTUALIZAR
		if (producto.getId() != null) {
			sql = "UPDATE PRODUCTOS SET NOMBRE=?, PRECIO=? WHERE ID=?";
		}else sql = "INSERT INTO PRODUCTOS(NOMBRE,PRECIO,FECHA_REGISTRO) VALUES(?,?,?)";
		try(Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			if (sql.contains("UPDATE")) {
				stmt.setLong(3, producto.getId());
			}else { stmt.setDate(3, new Date(producto.getFecha_registro().getTime()));
				
			}
			if(stmt.executeUpdate() > 0) return true;
			else return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
		
		return false;
	}

	@Override
	public boolean eliminar(long id) {
		String sql;
		try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM PRODUCTOS WHERE ID=?")) {
			stmt.setLong(1, id);
			if(stmt.executeUpdate() > 0) return true;
			else return false;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

}
