package jdbc.repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
	List<T> listar() throws SQLException;
	
	T porId(long id) throws SQLException;
	
	boolean guardar(T t) throws SQLException;
	
	boolean eliminar(long id) throws SQLException;
	
	
}
