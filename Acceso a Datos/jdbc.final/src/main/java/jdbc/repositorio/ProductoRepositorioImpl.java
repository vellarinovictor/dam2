package jdbc.repositorio;

import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Producto;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

	@Override
	public List<Producto> listar() {
		List<Producto> productos = new ArrayList<Producto>();
		return null;
	}

	@Override
	public Producto porId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

}
