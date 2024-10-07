package javanio.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/fichero_binario");
		escribir(path);
		leer(path);

	}

	private static void leer(Path path) {
		byte[] bytesFicheros = new byte[] {};
		try {
			bytesFicheros = Files.readAllBytes(path);
		} catch (IOException e) {
			System.err.println("Error al leer los bytes del fichero");
			System.err.println(e.getMessage());
			System.exit(-4);
		}
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytesFicheros);
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
		} catch (IOException e) {
			System.err.println("Error al crear el ObjectInputStream");
			System.err.println(e.getMessage());
			System.exit(-5);
		}
		
		try {
			Curso curso = (Curso) objectInputStream.readObject();
			System.out.println(curso.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("Error al crear la clase");
			System.err.println(e.getMessage());
			System.exit(-6);
		} catch (IOException e) {
			System.err.println("Error de entrada salida");
			System.err.println(e.getMessage());
			System.exit(-7);
		}
		
	}

	private static void escribir(Path path) {
		Curso curso = new Curso(001,"Acceso a Datos",29);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = null;
		try {
			
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			
		} catch (IOException e) {
			System.err.println("Error al crear el ObjectOutputStream");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		try {
			objectOutputStream.writeObject(curso);
		} catch (IOException e) {
			System.err.println("Error al escribir en la RAM");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
		try {
			Files.write(path, byteArrayOutputStream.toByteArray());
		} catch (IOException e) {
			System.err.println("Error al escribir desde la RAM");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		System.out.println("Hemos escrito el objeto Curso en el fichero: "+path.getFileName());
	}

}
