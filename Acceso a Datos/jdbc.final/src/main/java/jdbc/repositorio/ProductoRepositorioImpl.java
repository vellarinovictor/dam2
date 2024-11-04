package jdbc.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Producto;
import jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
	private static Connection getConnection() throws SQLException{
		return ConexionBaseDatos.getInstance();
	}
	
	
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<Producto>();
		try(Statement stm = getConnection().createStatement()) {
			ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCTOS");
			while (rs.next()) {
				Producto p = new Producto(
						rs.getLong(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getDate(4)
						);
				System.out.println(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return productos;
	}

	@Override
	public Producto porId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

}
