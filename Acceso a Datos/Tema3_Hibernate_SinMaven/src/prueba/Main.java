package prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		System.out.println("Iniciamos la configuracion");
		final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
		final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
		System.out.println("Conectando a la Base de Datos...");
		final Session session = factory.openSession();
		System.out.println("Conectado correctamente a la Base de Datos.");
		session.close();
		System.out.println("Desconectado correctamente a la Base de Datos.");
	}

}
