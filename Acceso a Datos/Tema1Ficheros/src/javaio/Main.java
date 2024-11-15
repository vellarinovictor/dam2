package javaio;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Main {//Uso de FileUtils

	public static void main(String[] args) {
		System.out.println("Iniciando el programa...");
		File directorio = new File("ficheros3");
		//if (!directorio.mkdir()) {
			if (!directorio.mkdir()) {
				if (!directorio.exists()) {
					System.err.println("No hemos podido crear el directorio.");
				System.exit(-1);
				}
			}
		//}
		File fichero = new File(directorio,"fichero.txt");
		try {
			fichero.createNewFile();
			System.out.println("Fichero creado");
		} catch (IOException e) {
			System.err.println("NO se ha podido crear el fichero de forma correcta.");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		File renombre = new File(directorio, "fichero_de_copia.txt");
		fichero.renameTo(renombre);
		//Vamos a usar una nueva clase FileUtils
		try {
			FileUtils.copyFile(renombre, fichero);
		} catch (IOException e) {
			System.err.println("No se ha podido copiar el fichero "+fichero+" al fichero "+renombre+" correctamente");
		}
		//Vamos a usar una nueva clase FileUtils :::	MOVER UN FICHERO A OTRA CARPETA
		try {
			FileUtils.moveFile(fichero, new File("fichero5.txt"));
		} catch (IOException e) {
			System.err.println("No se ha podido mover el fichero correctamente");
		}
		//Vamos a borrar un fichero
		if(fichero.exists()){
			if (fichero.delete()) {
				System.out.println("Se ha borrado el fichero.");
			} else System.err.println("No se ha podido borrar el fichero");
		}
	}

}
