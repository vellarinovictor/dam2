package jdbcSinMaven;

import java.nio.file.Path;
import java.sql.Connection;

public class Main{
	public static void main(String[] args) {
        System.out.println("Conexión a jdbc sin Maven con H2:");
        String urlH2 = "jdbc:h2:" + Path.of("m06").toAbsolutePath().toString();
        String user = "root";
        String pass = "secret";
        System.out.println("Conectando al servidor H2...");
        try {
            Connection con = H2Connection.newInstance(urlH2, user, pass);
            System.out.println("Conectado con el servidor H2.");
            System.out.println("Cerrando conexión con el servidor H2...");
            con.close();
        } catch (Exception e) {
            System.err.println("No se ha podido conectar con el servidor H2.");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}