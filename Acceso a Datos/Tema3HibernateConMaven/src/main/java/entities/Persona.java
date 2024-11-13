package entities;

import java.util.Date;

public class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private Date fechaNacimiento;
	

	public Persona() {
	}

	public Persona(int id, String nombre, String apellidos, int edad, Date nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = nacimiento;
		this.apellidos = apellidos;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
