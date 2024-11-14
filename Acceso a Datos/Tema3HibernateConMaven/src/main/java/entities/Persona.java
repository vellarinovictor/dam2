package entities;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int edad;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	public Persona() {
	}

	public Persona(int id, String nombre, int edad, Date nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = nacimiento;
	}

	public Persona(String nombre, int edad, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public static Date newDate(int dia, int mes, int anio) {
		Calendar calendar = new Calendar.Builder().build();
		calendar.set(anio, (mes-1), dia);
		return calendar.getTime();
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
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}

}
