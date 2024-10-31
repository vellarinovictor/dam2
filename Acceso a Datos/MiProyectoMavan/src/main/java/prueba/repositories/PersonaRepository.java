package prueba.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prueba.entities.Direccion;
import prueba.entities.Persona;

public class PersonaRepository implements Repository<Persona> {

	Connection connection;

	public PersonaRepository(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Persona> findAll() {
		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT * FROM PERSONAS";
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return personas;
		}

		try {
			ResultSet resultSet = estado.getResultSet();
			while (!resultSet.isLast()) {
				resultSet.next();
				Persona persona = new Persona(resultSet.getInt(1), // ID
						resultSet.getString(2), // NOMBRE
						resultSet.getString(3), // PASSWORD
						resultSet.getString(4)// TELEFONO
				);
				personas.add(persona);
			}
			// return personas;
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar el resultSet.");
			System.err.println(e.getMessage());
		}

		return personas;
	}

	@Override
	public Persona findOneById(int id) {
		String query = "SELECT * FROM PERSONAS WHERE ID=?";

		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);

		try {
			estado.setInt(1, id);
			estado.executeQuery();
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return null;
		}

		try {
			ResultSet resultSet = estado.getResultSet();
			resultSet.next();
			return new Persona(resultSet.getInt(1), // ID
					resultSet.getString(2), // NOMBRE
					resultSet.getString(3), // PASSWORD
					resultSet.getString(4));// TELEFONO
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Persona save(Persona persona) {
		String query = "INSERT INTO PERSONAS(NOMBRE,PASSWORD,TELEFONO) VALUES(?,?,?)";
		PreparedStatement estado = null;
		try {
			estado = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			System.err.println("No se han podido crear la sentencia: " + query);
			System.err.println(e.getMessage());
		}
		try {
			estado.setString(1, persona.getNombre());
			estado.setString(2, persona.getPassword());
			estado.setString(3, persona.getTelefono());
			estado.executeUpdate();// La persona acaba de ser insertada en la Base de Datos
			ResultSet key = estado.getGeneratedKeys();
			key.next();// Nos posicionamos en la persona que nos ha devuelto
			persona.setId(key.getInt(1));// Le asignamos al objeto persona que hemos guardado el id de la base de datos
			System.out.println("Se han guardado los datos de la persona en la BBDD.");
			return persona;
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: " + query);
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		String query = "DELETE FROM PERSONAS WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setInt(1, id);
			if (estado.executeUpdate() > 0)
				System.out.println("Se ha borrado la persona");
			else
				System.out.println("No se ha borrado a la persona");
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: " + query);
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void updateById(int id, Persona persona) {
		String query = "UPDATE PERSONAS SET NOMBRE=?,PASSWORD=?,TELEFONO=? WHERE ID=?";
		PreparedStatement estado = JDBCOperations.crearSentencia(connection, query);
		try {
			estado.setString(1, persona.getNombre());
			estado.setString(2, persona.getPassword());
			estado.setString(3, persona.getTelefono());
			estado.setInt(4, id);
			if (estado.executeUpdate() > 0)
				System.out.println("Se ha modificado la persona");
			else
				System.out.println("No se ha modificado ninguna persona");
		} catch (SQLException e) {
			System.err.println("No se han podido colocar los datos: " + query);
			System.err.println(e.getMessage());
		}
	}

	public List<Persona> findAllWithDirecciones() {
		Statement estado = JDBCOperations.crearSentencia(connection);
		String query = "SELECT P.ID,P.NOMBRE,P.PASSWORD,P.TELEFONO,D.ID,D.DIRECCION FROM PERSONAS P INNER JOIN DIRECCIONES D ON P.ID = D.PERSONA_ID ORDER BY P.ID";
		ArrayList<Persona> personas = new ArrayList<>();

		try {
			estado.executeQuery(query);
		} catch (SQLException e) {
			System.err.println("No se han podido recuperar los datos: " + query);
			System.err.println(e.getMessage());
		}

		try {
			ResultSet rS = estado.getResultSet();
			while (!rS.isLast()) {
				rS.next();
				Persona persona = new Persona(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4));
				Direccion direccion = new Direccion(rS.getInt(5), rS.getInt(1), rS.getString(6));
				
				
				if (personas.contains(persona)) {//si no es la primera vez que aparece la persona
					int posicion = personas.indexOf(persona);
					Persona p = personas.get(posicion);
					p.addDireccion(direccion);
					personas.set(posicion, p);
				}else {//si es la primera vez que aparece la persona 
					persona.addDireccion(direccion);
					personas.add(persona);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personas;
	}

}
