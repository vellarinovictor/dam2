package repaso;

public class ejercicio1 {
	public static void main(String[] args) {
		int mates=6,lengua=7,ingles=4,informatica=6;
		//System.out.println("La media es " + media2(mates,lengua,ingles,informatica));
		System.out.println("La media es " + media2(mates,lengua,ingles,informatica));
	}

	private static Double media2(int... valores) {
		double suma=0;
		for(int valor:valores) {
			suma+=valor;
		}
		return suma/valores.length;
	}
}