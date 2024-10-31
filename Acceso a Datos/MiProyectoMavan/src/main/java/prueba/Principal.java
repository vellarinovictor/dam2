package prueba;

import java.sql.Connection;
import java.util.List;

import prueba.entities.Persona;
import prueba.repositories.PersonaRepository;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Conexion a JDBC con MYSQL.");
		String urlMysql = "jdbc:mysql://localhost/censojerez";
		String username = "root";
		String password="";
		System.out.println("Conectando al servidor MYSQL");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);
		System.out.println("Iniciando conexion");
		PersonaRepository repository = new PersonaRepository(connection);

//		Persona persona = new Persona("Nachete","qwerty","123456");
//		System.out.println("La almacenamos en la base de datos");
		
//		repository.save(persona);	
//		System.out.println("Persona almacenada en la base de datos");
//		System.out.println(persona.toString()+" almacenada en la base de datos");
//		System.out.println(repository.findOneById(persona.getId())+" recuperada de la base de datos");
		
//		for (Persona per : repository.findAll()) {
//			System.out.println(per);
//		}
		
//		persona.setPassword("123contra321");
//		System.out.println("Hemos cambiado la contraseña");
//		repository.updateById(persona.getId(),persona);
//		
//		
//		System.out.println(repository.findOneById(persona.getId()));
		
//		repository.deleteById(persona.getId());
		
//		for (Persona per : repository.findAll()) {
//			System.out.println(per);
//		}
//		
		for (Persona per : repository.findAllWithDirecciones()) {
			System.out.println(per);
		}
	}

}
