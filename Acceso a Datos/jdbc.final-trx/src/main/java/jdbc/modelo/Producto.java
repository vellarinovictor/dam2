package jdbc.modelo;

import java.util.Date;
import java.util.List;

import jdbc.repositorio.Repositorio;

public class Producto{
	private Long id;
	private String nombre;
	private int precio;
	private Date fecha_registro;
	private Categoria categoria;
	private String sku;
	
	
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Producto(Long id, String nombre, int precio, Date fecha_registro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_registro = fecha_registro;
	}
	public Producto(String nombre, int precio, Date fecha_registro) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fecha_registro = fecha_registro;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Producto ["+id 
				+ " | " + nombre 
				+ " | " + precio 
				+ " | " + fecha_registro
				+ " | " + categoria
				+ " | " + sku
				+ "]";
	}
	
}