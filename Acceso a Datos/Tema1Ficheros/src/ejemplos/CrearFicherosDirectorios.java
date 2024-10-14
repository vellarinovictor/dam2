package ejemplos;

import java.io.File;
import java.io.IOException;

public class CrearFicherosDirectorios {

    public static void main(String[] args) {
        File directorio = new File("resources/crearFicheros");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado en: " + directorio.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio.");
                return;
            }
        }
        File fichero = new File(directorio, "fichero.txt");

        try {
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado en: " + fichero.getPath());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida.");
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}
