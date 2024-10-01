using LibreriaV3._1.Modelo;
using System;
using System.Collections.Generic;

public class Estanteria
{


    //ArrayList donde se almacena cada LIBRO
    private List<Libro> libros = new List<Libro>();

	//------------------------------METODOS 
    /**
	* Inserta un libro en un arrayList
	* @param obLibro
	* @return True/False
	*/
    public Boolean insertarLibro(Libro oblibro)
    {
        if (buscarLibro(oblibro.Titulo) == null)
        {
            libros.Add((oblibro));
            return true;
        }//if
        else
            return false;
    }//insertarLibro

     /**
	 * Modifica un libro en el ArrayList. Primero se localiza y si se encuentra se borra y añade uno nuevo
     * con los datos procedentes del objeto.
	 */
    public Boolean  modificarLibro(Libro oblibro)   
    {
        Boolean modificado = false;
        Libro libro = buscarLibro(oblibro.Titulo);
        if (libro!=null)
        {
            libros.Remove(libro);
            libros.Add(oblibro);
            modificado = true;
        }
        return modificado;
    }//modificarLibro

    /**
	 * Entra por parametros una String con un titulo, y te devuelve el objeto libro exacto
	 * @param nombre
	 * @return
	 */
    public Libro buscarLibro(string nombre)
    {
        foreach (var libro in libros)
        {
            if (libro.Titulo.Equals(nombre))
            {
                return libro;
            }
     
        }//foreach
        return null;
    }//buscarLibro

     /**
      * Borra un libro del arrayList a través del nombre
      * @param nombre
      * @return True/False
      */
    public Boolean borrarLibro(string nombre)
    {
        Boolean borrado = false;
        if (libros.Count!=0)
        {
            libros.Remove(buscarLibro(nombre));
            borrado=true;
        }
        return borrado;
    }//borrarLibro
}//class