using LibreriaV2.Modelo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Datos
{
  public class AccesoLibro : AccesoBD , IAcceso<TLibro> {

	public Boolean insertarLibro(TLibro obLibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlInsertarLibro(obLibro));
		} catch (Exception e) {
                throw;
		}

	}
	public Boolean borrarLibro(TLibro oblibro) {
		try {
			return ejecutarUpdate(UtilSQL.sqlBorrarLibro(oblibro.Titulo));
		} catch (Exception e) {
			    throw;
		}
	}

    public object buscarLibro(string nombre) {

        try { 
             return ejecutarConsulta(UtilSQL.sqlBuscarLibro(nombre), new TLibro()).First();
        } catch (Exception e) {
                throw;
        }
    }

    public List<object> obtenerLibros() {

         try{
             return ejecutarConsulta(UtilSQL.sqlObtenerLibros(), new TLibro());
         }catch (Exception e){
               throw;
            }
    }


    public Boolean modificarLibro(TLibro obLibro)
    {
        try
        {
            return ejecutarUpdate(UtilSQL.sqlModificarLibro(obLibro));
        }
        catch (Exception e)
        {
            throw;
        }
    }
  }   
}
