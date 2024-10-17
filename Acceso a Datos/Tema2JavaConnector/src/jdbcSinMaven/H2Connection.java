package jdbcSinMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    private H2Connection(){}
    
    public static Connection newInstance(String url, String user, String pass) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("Error en la conexión con la BBDD.");
            e.printStackTrace();
            System.exit(-1);
        }
        return con;
    }
    
}