package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmnt = null;
		try {
			conn = ConectorBBDD.conector();
			System.out.println("Conectado");
			String sql = "SELECT * FROM examenes";
			stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(sql);
			while (rs.next()) {
				int cod=rs.getInt(1);
				String des=rs.getString(2);
				System.out.printf("Codigo examen: %d\tDescripcion examen: %s\n",cod,des);
			}
			rs.close();
			stmnt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
