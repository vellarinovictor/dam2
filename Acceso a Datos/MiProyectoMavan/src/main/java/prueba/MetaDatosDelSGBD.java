package prueba;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDatosDelSGBD {

	public static void main(String[] args) {
		System.out.println("Conexion a jdbc con de mysql");
		String urlMysql = "jdbc:mysql://localhost/censojerez";
		String username = "root";
		String password = "";
		System.out.println("Conexion al servidor Mysql");
		Connection connection = MySQLConnection.newInstance(urlMysql, username, password);
		
		try {
			DatabaseMetaData misDatosDB = connection.getMetaData();
			System.out.println("Nombre del SGBD: "+ misDatosDB.getDatabaseProductName());
			System.out.println("Version del SGBD: "+  misDatosDB.getDatabaseProductVersion());
			System.out.println("Nombre del Driver del SGBD: "+  misDatosDB.getDriverName());
			System.out.println("Version del driver del SGBD: "+  misDatosDB.getDriverVersion());
			System.out.println("Nivel de aislamiento: "+  misDatosDB.getDefaultTransactionIsolation());
			System.out.println("Usuario actual: "+  misDatosDB.getUserName());
			System.out.println("Bases de datos: ");
			ResultSet rS = misDatosDB.getCatalogs();
			List<String> bbdds = new ArrayList<String>();
			while (!rS.isLast()) {
				rS.next();
				bbdds.add(rS.getString(1));
				System.out.println(rS.getString(1));
			}
			
			for (String bd : bbdds) {
				//misDatosDB.getTables(bd, bd, bd, args);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
