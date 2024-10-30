using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;

namespace LibreriaV5_1_Final.Persistencia
{
    public class AccesoDAO<T> : AccesoBD, IAcceso<T> where T : new()
    {
        public bool BorradoVirtual(List<T> objetos)
        {
            /*
             Se sabe que se puede obtener una propiedad en concreto preguntado por su nombre, 
             pero esto modificaría el orden de como obtiene las propiedades en EjecutarUpdate. 
             El orden pasa de ser de “el orden en el que estén declarados los atributos de una clase Entity” a 
             “primero el atributo modificado, después el orden de los atributos declarados” 
             provocando fallos a la hora de insertar valores en la sql parametrizada.
             De esta forma obtenemos la lista completa y no modificamos su orden.
             */
            string sql;
            bool borrado = true;
            try
            {
                int index = 0;

                while (borrado && index < objetos.Count)
                {
                    borrado = false;
                    PropertyInfo[] properties = objetos[index].GetType().GetProperties();
                    properties[properties.Length - 1].SetValue(objetos[index], "1");
                    if ((sql = UtilFichero.ObtenerSentencia("BORRADOVIRTUAL" + objetos[index].GetType().Name)) == null)
                    {
                        sql = UtilSQL.SqlModificar(objetos[index]);
                        UtilFichero.GuardarSQL("BORRADOVIRTUAL" + objetos[index].GetType().Name, sql);
                    }

                    if (EjecutarUpdate(UtilSQL.Parametrizar(objetos[index], sql), index == objetos.Count - 1))
                    {
                        borrado = true;
                    }
                    index++;
                }
            }
            catch (Exception) { throw; }

            return borrado;
        }

        public bool Borrar(List<T> objetos)
        {
            string sql;
            bool borrado = true;
            try
            {
                int index = 0;

                while (borrado && index < objetos.Count)
                {
                    borrado = false;
                    if ((sql = UtilFichero.ObtenerSentencia("DELETE" + objetos[index].GetType().Name)) == null)
                    {
                        sql = UtilSQL.SqlBorrar(objetos[index]);
                        UtilFichero.GuardarSQL("DELETE" + objetos[index].GetType().Name, sql);
                    }
                    if (EjecutarUpdate(UtilSQL.Parametrizar(objetos[index], sql), index == objetos.Count - 1))
                    {
                        borrado = true;
                    }
                    index++;
                }
            }
            catch (Exception) { throw; }

            return borrado;
        }
        //
        public object BuscarOne(Type clase, string nombre)
        {
            List<object> list = null;
            Object obj = null;
            String sql;
            try
            {
                // Si la orden SQL no existe se guarda en un Dictionary, que al terminar
                // el programa guardará todas las órdenes en el fichero sql.txt
                if ((sql = UtilFichero.ObtenerSentencia("SELECTONE" + clase.Name)) == null)
                {
                    //De esta forma se puede ver mejor la construcción de la orden SQL.
                    sql = UtilSQL.SqlBuscar(clase);
                    UtilFichero.GuardarSQL("SELECTONE" + clase.Name, sql);
                }
                //if ((list = EjecutarConsulta(sql, clase, nombre)).Count != 0)
                if ((list = EjecutarConsulta(sql, clase, nombre)).Count != 0)
                {
                    obj = list.First();
                }
            }
            catch (Exception) { throw; }
            return obj;
        }

        public List<object> Buscar(Type clase, string campo, string busqueda)
        {
            String sql = "SELECT * FROM " + clase.Name + " WHERE " + campo + " = \"" + busqueda + "\"";
            try
            {
                return EjecutarConsulta(sql, clase, "");
            }
            catch (Exception) { throw; }
        }

        public bool Insertar(List<T> objetos)
        {
            bool insertado = true;
            string sql;

            try
            {
                int index = 0;
                while (insertado && index < objetos.Count)
                {

                    insertado = false;
                        if ((sql = UtilFichero.ObtenerSentencia("INSERTAR" + objetos[index].GetType().Name)) == null)
                        {
                            sql = UtilSQL.SqlInsertar(objetos[index]);
                            UtilFichero.GuardarSQL("INSERTAR" + objetos[index].GetType().Name, sql);
                        }
                        if (EjecutarUpdate(UtilSQL.Parametrizar(objetos[index], sql), index == objetos.Count - 1)) //Se hace commit si llega al final
                        {
                            insertado = true;
                        }
                    index++;
                }
            }
            catch (Exception) { throw; }
            return insertado;
        }

        public bool Modificar(List<T> objetos)
        {
            bool modificado = true;
            string sql;

            try
            {
                int index = 0;
                while (modificado && index < objetos.Count)
                {
                    modificado = true;
                    if ((sql = UtilFichero.ObtenerSentencia("UPDATE" + objetos[index].GetType().Name)) == null)
                    {
                        sql = UtilSQL.SqlModificar(objetos[index]);
                        UtilFichero.GuardarSQL("UPDATE" + objetos[index].GetType().Name, sql);
                    }
                    if (EjecutarUpdate(UtilSQL.Parametrizar(objetos[index], sql), index == objetos.Count - 1))
                    {
                        modificado = true;
                    }
                    index++;
                }
            }
            catch (Exception) { throw; }

            return modificado;
        }

        public List<Object> BuscarAll(Type clase)
        {
            List<Object> obj = null;
            string sql;
            try
            {
                if ((sql = UtilFichero.ObtenerSentencia("SELECTALL" + clase.Name)) == null)
                {
                    sql = UtilSQL.SqlObtener(clase);
                    UtilFichero.GuardarSQL("SELECTALL" + clase.Name, sql);
                }
                obj = EjecutarConsulta(sql, clase, "");
            }
            catch (Exception) { throw; }

            return obj;

        }
        public string ObtenerCodigo(Type clase)
        {
            String codigo = "";
            try
            {
                string sql = "SELECT * FROM " + clase.Name.ToLower() + " WHERE Cod" + clase.Name.Substring(1) + " = (SELECT MAX(Cod" + clase.Name.Substring(1) + ") FROM " + clase.Name.ToLower() + ")";
                List<Object> resultados = EjecutarConsulta(sql, clase, "");
                if (resultados.Count != 0)
                {
                    PropertyInfo clave = clase.GetProperty(UtilSQL.ObtenerClave(clase));
                    codigo = clave.GetValue(resultados[0]).ToString();
                }
                else
                {
                    codigo = "Cod000";
                }
            }
            catch (Exception) { throw; }

            return codigo;
        }

    }
}
