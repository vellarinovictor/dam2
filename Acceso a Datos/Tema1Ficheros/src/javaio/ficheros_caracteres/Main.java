package javaio.ficheros_caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		File file = new File("ficheros/caracteres.txt");
		escribir(file);
		leer(file);
	}

	private static void leer(File file) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir el FileReader");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-4);
		}
		int read;
		try {//Leemos el archivo
			while ((read = fileReader.read())!=-1) {
				System.out.print((char)read);
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer el archivo.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-5);
		}
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.println("Error al cerrar el FileReader.");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-6);
		}
		
	}

	private static void escribir(File file) {
		//Debemos usar un FileWriter. Escribimos el texto deseado.
		//MUY IMPORTANTE: Cerrar el flujo del fichero abierto.
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file); 
			// Esto borra el contenido actual del documento y graba lo que pongamos.
			// Para añadir contenido a un archivo con datos ya grabados, usamos la siguiente declaracion:
			// FileWriter fileWriter = new FileWriter(file,true)
		} catch (IOException e) {
			System.err.println("No se ha podido abrir el FileWriter");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		try {//Escribimos el texto deseado
			fileWriter.write("Vamos a escribir primer prueba!!!\n"
					+ "\r\n"
					+ "\r\n"
					+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam risus neque, ultrices ut ultrices sit amet, volutpat in purus. Suspendisse aliquam congue dignissim. Nullam laoreet eros ac felis placerat posuere. Nulla vel metus et dui tincidunt tristique. Morbi in leo orci. Pellentesque quam elit, molestie a pellentesque in, molestie vitae odio. Sed vestibulum augue non neque gravida sagittis. Nunc nec congue quam. Sed eros nibh, bibendum ut sagittis ac, vehicula a est. Duis ligula elit, condimentum non tempus non, suscipit aliquam velit. Duis lacinia fringilla justo. Proin ut nisi eros.\r\n"
					+ "\r\n"
					+ "Donec lacinia mattis lectus, et molestie leo consequat vitae. Nunc sed bibendum ante. Pellentesque non mi ullamcorper, convallis leo ut, fermentum diam. Phasellus non vulputate magna. Quisque vel porttitor enim, id semper nibh. Suspendisse imperdiet enim nibh, ut facilisis lectus commodo sit amet. Sed dapibus turpis eros, eget ultricies urna tincidunt vel.\r\n"
					+ "\r\n"
					+ "Sed vel nisi nisl. Morbi in molestie felis. Donec sodales vehicula diam eget dictum. Fusce urna velit, convallis quis dui venenatis, mattis cursus tortor. Aenean in euismod odio. Maecenas rhoncus neque lorem, quis tincidunt massa lacinia ac. Curabitur placerat fermentum quam, et pellentesque ipsum faucibus eget. Ut suscipit iaculis fermentum.\r\n"
					+ "\r\n"
					+ "Vestibulum ultricies tortor mollis velit rhoncus sollicitudin. Phasellus eget volutpat nibh, a consectetur ligula. Aliquam vitae cursus sapien. Sed elementum semper lectus, a faucibus nunc consequat non. Integer tempor nulla quis mattis accumsan. Suspendisse hendrerit dignissim facilisis. Nulla tristique magna sed diam hendrerit luctus. Nunc massa mi, hendrerit vitae lorem congue, posuere consectetur arcu. Aliquam iaculis tempor mi, vitae eleifend ipsum varius aliquet. Nunc risus mauris, accumsan quis efficitur et, rhoncus sed ipsum. Nunc egestas magna posuere quam laoreet, et aliquet mauris lacinia. Integer congue sollicitudin felis, vitae ornare ligula imperdiet nec.\r\n"
					+ "\r\n"
					+ "Curabitur vel euismod ex. In hac habitasse platea dictumst. Pellentesque lobortis a lorem sed aliquam. Nulla dapibus enim ut faucibus tristique. Praesent et elit est. Maecenas turpis nunc, vulputate viverra libero at, ultricies ultrices dui. Donec blandit lorem mauris, vel consequat odio ullamcorper quis. Nulla condimentum erat eget dui facilisis molestie. Phasellus consectetur, ante quis hendrerit fringilla, dui tellus convallis erat, aliquet mattis diam purus ut justo. Etiam hendrerit felis at hendrerit porttitor. Suspendisse potenti. Vestibulum efficitur consectetur lacus, a fringilla sem rutrum vitae. "
					+ "\n");
		} catch (IOException e) {
			System.err.println("Error: Error al escribir con el FileWriter");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-2);
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el flujo");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-3);
		}
	}
}
