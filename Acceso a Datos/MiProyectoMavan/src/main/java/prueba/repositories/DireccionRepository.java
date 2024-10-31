package prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prueba.entities.Direccion;

public class DireccionRepository implements Repository<Direccion> {

Connection connection;
	
	public DireccionRepository(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<Direccion> findAll() {
		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM DIRECCIONES";
		ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: "+query);
			System.err.println(e.getMessage());
			return direcciones;
		}
		
		try {
			ResultSet resultSet = estado.getResultSet();
			while (!resultSet.isLast()) {
				resultSet.next();
				Direccion direccion = new Direccion(
						resultSet.getInt(1),//ID
						resultSet.getInt(1),//ID_PERSONA
						resultSet.getString(2)//DIRECCION
						);
				direcciones.add(direccion);
			}
			//return direcciones;
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar el resultSet.");
			System.err.println(e.getMessage());
		}
		
		return direcciones;
	}

	@Override
	public Direccion findOneById(int id) {
		String query = "SELECT * FROM DIRECCIONES WHERE ID=?";
		
		PreparedStatement estado = JDBCOperations.crearSentencia(connection,query);
		
		try {
			estado.setInt(1,id);
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: "+query);
			System.err.println(e.getMessage());
			return null;
		}
		
		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Direccion(
					resultSet.getInt(1),//ID
					resultSet.getInt(1),//ID_PERSONA
					resultSet.getString(2)//DIRECCION
					);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: "+query);
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Direccion save(Direccion direccion) {
		String query = "INSERT INTO DIRECCIONES(ID_PERSONA,DIRECCION) VALUES(?,?)";
		PreparedStatement estado = null;
		try {
			estado = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			System.err.println("No se han podido crear la sentencia: "+query);
			System.err.println(e.getMessage());
		}
		try {
			estado.setInt(1, direccion.getPersonaId());
			estado.setString(2, direccion.getDireccion());
			estado.executeUpdate();//La direccion acaba de ser insertada en la Base de Datos
			ResultSet key = estado.getGeneratedKeys();
			key.next();//Nos posicionamos en la direccion que nos ha devuelto
			direccion.setId(key.getInt(1));//Le asignamos al objeto direccion que hemos guardado el id de la base de datos
			System.out.println("Se han guardado los datos de la direccion en la BBDD.");
			return direccion;
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: "+query);
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		String query = "DELETE FROM DIRECCIONES WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			if(estado.executeUpdate() > 0) System.out.println("Se ha borrado la direccion");
			else System.out.println("No se ha borrado a la direccion");
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: "+query);
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateById(int id, Direccion direccion) {
		String query = "UPDATE DIRECCIONES SET ID_PERSONA=?,DIRECCION=? WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, direccion.getPersonaId());
			estado.setString(2, direccion.getDireccion());
			estado.setInt(3, direccion.getId());
			if(estado.executeUpdate() > 0) System.out.println("Se ha modificado la direccion");
			else System.out.println("No se ha modificado ninguna direccion");
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: "+query);
			System.err.println(e.getMessage());
		}
	}

}
