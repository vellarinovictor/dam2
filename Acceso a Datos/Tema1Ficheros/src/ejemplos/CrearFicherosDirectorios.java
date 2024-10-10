package ejemplos;

import java.io.File;

public class CrearFicherosDirectorios {
//Debemos crear un directorio en nuestro proyecto dentro de la carpeta resource
	//nombre del directorio crearFicheros
	//y creamos un fichero llamado fichero.txt
	//Clases que podemos usar: File
	public static void main(String[] args) {
		File directorio = new File("resources/crearFicheros");
		File fichero = new File(directorio,"fichero.txt");
		System.out.println("Fichero creado en "+fichero.getAbsolutePath());
	}

}
