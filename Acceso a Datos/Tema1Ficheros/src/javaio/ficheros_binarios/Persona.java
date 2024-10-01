package javaio.ficheros_binarios;

import java.io.Serializable;

public class Persona implements Serializable{
	//Objeto Persona es un ejemplo de POJO
	//Vamos a hacer este objeto suceptible de ser serializado
	private String nombre,direccion;
	private int id,edad;
	public Persona(int id, String nombre, int edad, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.id = id;
		this.edad = edad;
	}
	
	public Persona() {
		
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", id=" + id + ", edad=" + edad + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
