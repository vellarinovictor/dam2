package javaio.ficheros_aleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/aleatorio.txt");
		//Necesitamos el RandomAccessFile
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile  = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero: "+file.getName());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		pointer(randomAccessFile);//Me imprime donde está el puntero.
		escribir(randomAccessFile,"Hola Mundo!");
		pointer(randomAccessFile);
		colocarPuntero(randomAccessFile,0);
		pointer(randomAccessFile);
		leer(randomAccessFile);
		
		
		
		
		
		
		
		
	}

	private static void leer(RandomAccessFile randomAccessFile) {
		String leido;
		try {
			while ((leido = randomAccessFile.readLine())!=null) {
				System.out.println(leido);
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer el archivo.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-5);
		}
		
	}

	
	
	private static void colocarPuntero(RandomAccessFile randomAccessFile, int posicion) {
		try {
			randomAccessFile.seek(posicion);
		} catch (IOException e) {
			System.err.println("No se ha podido mover el puntero.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-4);
		}
		
	}
	
	

	private static void escribir(RandomAccessFile randomAccessFile, String texto) {
		System.out.println("Vamos a escribir en el fichero aleatorio, lo siguiente: "+texto);
		try {
			randomAccessFile.writeBytes(texto);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el documento.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-2);
		}
		
	}

	private static void pointer(RandomAccessFile randomAccessFile) {
		try {
			System.out.println("Posicion del puntero: "+randomAccessFile.getFilePointer());
		} catch (IOException e) {
			System.err.println("No se ha podido acceder al puntero.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-3);
		}
		
	}
	
	

}
