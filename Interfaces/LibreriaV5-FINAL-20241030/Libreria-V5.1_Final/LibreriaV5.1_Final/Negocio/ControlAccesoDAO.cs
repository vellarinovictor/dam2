using LibreriaV5_1_Final.Persistencia;
using System;
using System.Collections.Generic;


namespace LibreriaV5_1_Final.Negocio
{
    public class ControlAccesoDAO<T> : IAcceso<T> where T : new()
    {
        AccesoDAO<T> accesoDAO = new AccesoDAO<T>();

        public bool BorradoVirtual(List<T> objetos)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).BorradoVirtual(objetos);
            }
            catch (Exception) { throw; }
        }

        public bool Borrar(List<T> objetos)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Borrar(objetos);
            }
            catch (Exception) { throw; }
        }

        public object BuscarOne(Type clase, string nombre)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).BuscarOne(clase, nombre);
            }
            catch (Exception) { throw; }
        }

        public List<object> Buscar(Type clase, string campo, string busqueda)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Buscar(clase, campo, busqueda);
            }
            catch (Exception) { throw; }
        }

        public bool Insertar(List<T> objetos)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Insertar(objetos);
            }
            catch (Exception) { throw; }
        }

        public bool Modificar(List<T> objetos)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).Modificar(objetos);
            }
            catch (Exception) { throw; }
        }

        public List<object> BuscarAll(Type clase)
        {
            try
            {
                return ((IAcceso<T>)accesoDAO).BuscarAll(clase);
            }
            catch (Exception) { throw; }
        }

        public void CerrarAplicacion()
        {
            accesoDAO.CloseConnection();
        }
    }
}
