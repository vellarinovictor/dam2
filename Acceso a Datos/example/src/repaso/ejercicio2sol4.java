package repaso;

import java.util.Arrays;
import java.util.List;

public class ejercicio2sol4 {

	public static void main(String[] args) {
		List<Alumno> alumnos=Arrays.asList(
				new Alumno("Pepe",Arrays.asList(
					new Asignatura("Matematicas",6),
					new Asignatura("Lengua",3),
					new Asignatura("Inglés",5),
					new Asignatura("informática",9)
					)),
				new Alumno("Juan",Arrays.asList(
						new Asignatura("Matematicas",2),
						new Asignatura("Lengua",6),
						new Asignatura("Inglés",5),
						new Asignatura("informática",6)
						)),
				new Alumno("Navas",Arrays.asList(
						new Asignatura("Matematicas",2),
						new Asignatura("Lengua",10),
						new Asignatura("Inglés",6),
						new Asignatura("informática",8)
						))
				);
		System.out.println("Solucón A:");
		alumnos.forEach(alumno->{
			System.out.println("Alumno "+alumno.getNombre());
			alumno.getAsignaturas().forEach(
					asignatura->System.out.println("Nota de "+asignatura.getNombre()+" : "+asignatura.getNota()));
			System.out.println("Nota media : "+alumno.media());
		});
	}

}
