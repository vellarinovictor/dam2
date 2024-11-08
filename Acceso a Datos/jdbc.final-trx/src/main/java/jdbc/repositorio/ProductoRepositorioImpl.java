package jdbc.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.mysql.cj.jdbc.result.CachedResultSetMetaDataImpl;

import jdbc.modelo.Categoria;
import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
	private static Connection getConnection() throws SQLException {
		return ConexionBaseDatos.getInstance();
	}

	public List<Producto> listar() throws SQLException {
		List<Producto> productos = new ArrayList<Producto>();
		try (Statement stm = getConnection().createStatement()) {
			ResultSet rs = stm.executeQuery("SELECT P.*, C.NOMBRE as categoria FROM PRODUCTOS P INNER JOIN CATEGORIAS C ON P.CATEGORIA_ID = C.ID");
			while (rs.next()) {
				productos.add(crearProducto(rs));
			}

		}

		return productos;
	}

	@Override
	public Producto porId(long id) throws SQLException {
		Producto producto = null;
		try (PreparedStatement stmt = getConnection().prepareStatement("SELECT P.*, C.NOMBRE as categoria FROM PRODUCTOS P INNER JOIN CATEGORIAS C ON P.CATEGORIA_ID = C.ID WHERE P.ID = ?")) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					producto = crearProducto(rs);
					return producto;
				}
			}
		}
		return null;
	}

	@Override
	public boolean guardar(Producto producto) throws SQLException {
		String sql;
		//VAMOS A APROVECHAR PARA GUARDAR Y ACTUALIZAR
		if (producto.getId() != null) sql = "UPDATE PRODUCTOS SET NOMBRE=?, PRECIO=?, CATEGORIA_ID=?, SKU=? WHERE ID=?";
		else sql = "INSERT INTO PRODUCTOS(NOMBRE,PRECIO,CATEGORIA_ID,SKU,FECHA_REGISTRO) VALUES(?,?,?,?,?)";
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setString(1, producto.getNombre());
			stmt.setInt(2, producto.getPrecio());
			stmt.setLong(3, producto.getCategoria().getId());
			stmt.setString(4, producto.getSku());
			if (sql.contains("UPDATE")) {
				stmt.setLong(5, producto.getId());
			}else { stmt.setDate(5, new Date(producto.getFecha_registro().getTime()));
				
			}
			if(stmt.executeUpdate() > 0) return true;
			else return false;
		}
	}

	@Override
	public boolean eliminar(long id) throws SQLException {
		try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM PRODUCTOS WHERE ID=?")) {
			stmt.setLong(1, id);
			if(stmt.executeUpdate() > 0) return true;
			else return false;
		}
	}
	
	private Producto crearProducto(ResultSet rs) throws SQLException{
		Producto p = new Producto();
		p.setId(rs.getLong("id"));
		p.setNombre(rs.getString("nombre"));
		p.setPrecio(rs.getInt("precio"));
		p.setFecha_registro(rs.getDate("fecha_registro"));
		p.setSku(rs.getString("sku"));
		Categoria categoria = new Categoria();
		categoria.setId(rs.getLong("categoria_id"));
		categoria.setNombre(rs.getString("categoria"));
		p.setCategoria(categoria);
		return p;
	}

}
