package repaso;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ejercicio1sol2 {

	public static void main(String[] args) {
		String nombre="Monica Garcia";
		Asignatura[] asignaturas= {
				 new Asignatura("matematicas",6),
				 new Asignatura("lengua",7),
				 new Asignatura("ingles",4),
				 new Asignatura("informatica",6)
		};
		List<Asignatura> asignaturas2 = Arrays.asList(asignaturas);
		System.out.println("Alumno : "+nombre);
		asignaturas2.forEach(a->System.out.println("Nota de "+a.getNombre()+" : "+a.getNota()));
		System.out.println("Nota media : "+media(asignaturas2));
		
		asignaturas2.stream()
		.filter(a->a.getNombre().startsWith("m"))
		.forEach(System.out::println);
		System.out.println("Nota media : "+media(asignaturas2));
	}
	
	
	
	
	
	private static Double media(List<Asignatura> asignaturas) {
		double suma=0;
		for(Asignatura asignatura:asignaturas) {
			suma+=asignatura.getNota();
		}
		return suma/asignaturas.size();
	}
}
