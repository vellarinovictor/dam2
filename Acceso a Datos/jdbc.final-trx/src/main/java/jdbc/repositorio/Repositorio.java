package jdbc.repositorio;

import java.util.List;

public interface Repositorio<T> {
	List<T> listar();
	
	T porId(long id);
	
	boolean guardar(T t);
	
	boolean eliminar(long id);
	
	
}
