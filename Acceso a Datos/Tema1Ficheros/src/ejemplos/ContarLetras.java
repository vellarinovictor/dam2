package ejemplos;

import java.io.FileReader;

import javax.swing.JOptionPane;

public class ContarLetras {

	public static void main(String[] args) {
		String ruta = JOptionPane.showInputDialog(null,"Inserta ruta","Insercion",JOptionPane.INFORMATION_MESSAGE);
		int contarVocales =0;
		int contarConsonantes= 0;
		int contarNumeros=0;
		try(FileReader fr = new FileReader(ruta)) {
			int caracter;
			int vacales[]= {65,69,73,75,79,85};
			boolean esVocal;
			while((caracter = fr.read())!=-1) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
