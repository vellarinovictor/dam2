using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MiLibreriaV4.Datos;

namespace MiLibreriaV4.Negocio
{
    internal class AccesoLibro : AccesoBD , IAcceso<TMovil>
    {
        public bool borrarMovil(TMovil objetoMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlBorrarLibro(objetoMovil.Modelo));
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public object buscarMovil(string nombre)
        {
            try
            {
                return ejecutarConsulta(UtilSQL.sqlBuscarLibro(nombre), new TMovil()).First();
            }
            catch (Exception e)
            {
                throw;
            }   
        }

        public bool insertarMovil(TMovil objetoMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlInsertarLibro(objetoMovil));
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public bool modificarMovil(TMovil objetoMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlModificarMovil(objetoMovil));
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public List<object> obtenerMoviles()
        {
            try
            {
                return ejecutarConsulta(UtilSQL.sqlObtenerLibros(), new TMovil());
            }
            catch (Exception e)
            {
                throw;
            }
        }

      
    }
}
