package ejemplos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class LecturaEscritura {

	public static void main(String[] args) {
		Path path = Path.of("ejemplos/recursos/ejercicio1.txt");
		System.out.println(path.normalize().toString());
		System.out.println(path.toAbsolutePath());
		//Creamos esa ruta en el sustema de archivos, creamos el directorio
		try {
			Files.createDirectories(path.getParent());
		} catch (IOException e) {
			System.err.println("Error al crear el directorio");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-4);
		}
		//Creamos en esa ruta en el sistema de archivos, creamos el archivo
		File file = path.toFile();
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Error al crear el ficero en el path: "+path.toString());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		escribir(path);
		leer(path);
	}

	private static void leer(Path path) {
		try {
			List<String> lista = Files.readAllLines(path);
			for (String item : lista) {
				System.out.println( item.toString());
			}
		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		
	}

	private static void escribir(Path path) {
		try {
			Files.writeString(path, "Hola Mundo");
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		
	}

}
