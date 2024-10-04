package javanio.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/fichero_binario");
		escribir(path);

	}

	private static void escribir(Path path) {
		// TODO Auto-generated method stub
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
			System.exit(-1);
		}
		System.out.println("Hemos escrito el objeto Curso en el fichero: "+path.getFileName());
	}

}
