package repaso;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private List<Asignatura> asignaturas;
	
	public Alumno() {
	}

	public Alumno(String nombre, List<Asignatura> asignaturas) {
		this.nombre = nombre;
		this.asignaturas = new ArrayList<Asignatura>(asignaturas);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", asignaturas=" + asignaturas + "]";
	}
	
	public Double media(){
		double suma=0;
		for(Asignatura asignatura:asignaturas) {
			suma+=asignatura.getNota();
		}
		return suma/asignaturas.size();
	}
	
	
	
}
