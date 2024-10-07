package javanio.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CaracteresFiles {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/caracteres.txt");
		escribir(path);
	}

	private static void escribir(Path path) {
		
		try {
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
			Files.writeString(path, "Hola mundo\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
