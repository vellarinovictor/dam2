package Conexion;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import entities.Persona;
import jakarta.persistence.Query;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciamos la configuracion");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		System.out.println("Conectando a la Base de Datos...");
		final Session session = factory.openSession();
		System.out.println("Conectado correctamente a la Base de Datos.");
		session.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			Persona persona = new Persona("Persona "+(i+1),(i+10), Persona.newDate(i+1,1+ i,2020 + i));
			session.persist(persona);
		}
		
		Query queryPersonas = session.createQuery("FROM Persona",Persona.class);
		List<Persona> personas = queryPersonas.getResultList();
		personas.forEach(System.out::println);
		
		
//		System.out.println(persona);
//		System.out.println("Antes de insertar: "+persona);
//		//session.save(persona);
//		session.persist(persona);
//		System.out.println("Despues de insertar: "+persona);
//		System.out.println(persona.getId());
//		persona.setNombre("Otro nombre");
//		session.update(persona);
//		System.out.println("Despues de actualizar: "+persona);
//
//		persona.setNombre("Jose Luis");
//		persona.setEdad(99);
//		session.update(persona);
//		session.merge(persona);
//		System.out.println("Despues de actualizar: "+persona);

		
		session.getTransaction().commit();
		session.close();
		System.out.println("Desconectado correctamente a la Base de Datos.");
		
		
	}

}
