package javaio.ficheros_caracteres;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/caracteres.txt");
		escribir(file);

	}

	private static void escribir(File file) {
		//Debemos usar un FileWriter. Escribimos el texto deseado.
		//MUY IMPORTANTE: Cerrar el flujo del fichero abierto.
	}

}
