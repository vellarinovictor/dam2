package prueba.repositories;

import java.util.List;

public interface Repository<T> {
	
	List<T> findAll();//SELECT * FROM
	
	T findOneById(int id);//SELECT * FROM ... WHERE ID=
	
	T save(T t);//INSERT INTO
	
	void deleteById(int id);//DELETE FROM
	
	void updateById(int id, T t);//UPDATE
	
}
