package repaso.ejercicio2;

public class Main {
	public static void main(String[] args) {
		 	/*Escriba un programa que visualice el precio final de compra de una camiseta cuyo
			precio es 15€. La camiseta tiene un descuento del 20% y el IVA aplicable es del 17%
			La salida tendrá el siguiente formato:
			Artículo: Camiseta
			Precio base: 15€
			Descuento aplicado: 3€
			Importe con IVA: 14.04*/
		double precio=15,descuento=0.2,iva=0.17;
		String nombre="camiseta";
		Articulo articulo = new Articulo("Camiseta",15,0.2,0.17);
		System.out.println("Artículo: "+articulo.getNombre());
		System.out.println("Precio base: "+articulo.getPrecio()+"€");
		System.out.println("Descuento Aplicado: "+articulo.descuentoAplicado()+"€");
		System.out.println("Precio con IVA: "+articulo.precioConDescuentoIva()+"€");
	}
}
