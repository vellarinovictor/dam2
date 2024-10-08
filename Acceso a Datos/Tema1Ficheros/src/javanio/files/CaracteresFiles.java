package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;

public class CaracteresFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/caracteres.txt");
		escribir(path);
		leer(path);
	}

	private static void leer(Path path) {
		try {
			List<String> lista = Files.readAllLines(path);
			for (String item : lista) {
				System.out.println(item.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void escribir(Path path) {
		
		try {
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el archivo");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}

}
