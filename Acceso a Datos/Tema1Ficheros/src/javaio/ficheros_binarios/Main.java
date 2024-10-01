package javaio.ficheros_binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Creamos un fichero donde guardar el objeto creado
		File file = new File("ficheros/objeto");
		guardarObjeto(file);
		leerObjeto(file);
	}

	private static void leerObjeto(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir el FileInputStream");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-6);
		}
		//Necesitamos el ObjectInputStream
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir el ObjectInputStream");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-7);
		}
		//Leeremos del fichero los datos de la persona
		try {
			Persona persona = (Persona) objectInputStream.readObject();
			System.out.println(persona.toString());
		} catch (ClassNotFoundException e) {
			System.err.println("No se ha podido recuperar el objeto del fichero");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-8);
		} catch (IOException e) {
			System.err.println("No se ha podido recuperar el objeto del fichero");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-9);
		}
		try {
			objectInputStream.close();
			fileInputStream.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el flujo");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-10);
		}
		
	}

	private static void guardarObjeto(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("No se ha podido crear el fichero "+file.getName());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		//Creamos el objeto Persona que deseamos guardar
		Scanner leer = new Scanner(System.in);
		System.out.println("Por favor dame el ID de la persona");
		int id = leer.nextInt();
		leer.nextLine();
		System.out.println("Por favor dame el nombre de la persona");
		String nombre = leer.next();
		System.out.println("Por favor dame la edad de la persona");
		int edad = leer.nextInt();
		leer.nextLine();
		System.out.println("Por favor dame la direccion de la persona");
		String direccion = leer.next();
		Persona persona = new Persona(id, nombre, edad, direccion);
		//Creamos el FileOutputStream para guardar el objeto desde la memoria RAM a un fichero
		//Flujo de datos de salida
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero "+file.getName());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-2);
		}
		//Convertir el objeto en Bytes, necesitamos ObjectOutputStream
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			System.err.println("No se ha podido crear el OutputStream");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-3);
		}
		//Escribimos el objeto en el ObjectOutputStream
		try {
			objectOutputStream.writeObject(persona);
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el fichero "+file.getName());
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-4);
		}
		//Cerramos los flujos abiertos correctamente
		try {
			objectOutputStream.close();
			fileOutputStream.close();
			leer.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el flujo");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(-5);
		}
	}

}
