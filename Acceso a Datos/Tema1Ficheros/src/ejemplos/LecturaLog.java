package ejemplos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LecturaLog {

	public static void main(String[] args) {
		/*
		 *  1. Realiza una lectura del fichero de log y si hay algún error debes adjuntarlo al fichero de incidencias.log.
		 *  La ruta del fichero de log tendrás que localizarlo en el fichero c:\ventas\config.txt. 
		 *  El fichero de configuración config.txt tendrá el siguiente formato:
		 *   puerto:8081 nomapp  
		 *   fichlog:c:\ventas\ventas.log numses:200
		 *   
		 *   */
		Path rutaConfig = Path.of("c:\\ventas\\config.txt");
		try {
			List<String> lista =  Files.readAllLines(rutaConfig);
            String linea = lista.get(1);
            int inicioRuta = linea.indexOf("fichlog:") + "fichlog:".length();
            int finRuta = linea.indexOf("numses:");
            Path rutaLog = Path.of(linea.substring(inicioRuta, finRuta).trim());
            Files.write
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
