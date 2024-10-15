package ejemplos;

import java.io.FileReader;
import javax.swing.JOptionPane;

public class ContarLetras {

	public static void main(String[] args) {
		//Cuando inicies el programa, inserta la ruta del archivo que quieras leer y procesar,
		//la carpeta raiz es la del proyecto asi que usa la ruta relativa del archivo.
		String ruta = JOptionPane.showInputDialog(null,"Inserta ruta","Insercion",JOptionPane.INFORMATION_MESSAGE);
		int contarVocales =0;
		int contarConsonantes= 0;
		int contarNumeros=0;
		try(FileReader fr = new FileReader(ruta)) {
			int caracter;
			int[] vocales= {65,69,73,75,79,85,97,101,105,111,117};
			int[] consonantes = {
				    // Mayúsculas
				    66, 67, 68, 70, 71, 72, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 86, 87, 88, 89, 90,
				    // Minúsculas
				    98, 99, 100, 102, 103, 104, 106, 107, 108, 109, 110, 112, 113, 114, 115, 116, 118, 119, 120, 121, 122
				};
			int[] numeros = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};


			boolean esVocal;
			boolean esNumero;
			while((caracter = fr.read())!=-1) {
				char ch = (char) caracter;
				esVocal=false;
				esNumero=false;
				for (int i = 0; i < vocales.length; i++) {
					if(vocales[i]==ch) {
						contarVocales++;
						esVocal=true;
					}
				}
				if(!esVocal)
				for (int i = 0; i < numeros.length; i++) {
					if (numeros[i]==ch) {
						contarNumeros++;
						esNumero=true;
					}
				}
				if (!esNumero && !esVocal) {
					for (int i = 0; i < consonantes.length; i++) {
						if (consonantes[i]==ch) {
							contarConsonantes++;
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error al leer el documento.");
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		System.out.printf("El fichero tiene %d vocales, %d consonante y %d numeros\n",contarVocales,contarConsonantes,contarNumeros);
	}

}
