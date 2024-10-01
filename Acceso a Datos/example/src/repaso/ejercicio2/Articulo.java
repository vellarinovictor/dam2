package repaso.ejercicio2;

public class Articulo {
	private double precio,descuento,iva;
	private String nombre;
	public Articulo() {
		
	}
	public Articulo(String nombre, double precio, double descuento, double iva) {
		super();
		this.precio = precio;
		this.descuento = descuento;
		this.iva = iva;
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Articulo [precio=" + precio + ", descuento=" + descuento + ", iva=" + iva + ", nombre=" + nombre + "]";
	} 
	
	//Funcionalidades
	
	public double descuentoAplicado(){
		return precio*descuento;
	}
	
	public double ivaAplicado() {
		return precio*iva;
	}
	
	public double precioConDescuento() {
		return precio*(1-descuento);
	}
	
	public double precioConDescuentoIva() {
		return precio*(1-descuento)*(1+iva);
	}
}
