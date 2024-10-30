using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Reflection;

namespace LibreriaV5_1_Final.Persistencia
{
    public abstract class AccesoBD
    {
        private static MySqlConnection connection = null;
        private MySqlCommand comando;

        public AccesoBD()
        {
            try
            {
                connection = Conexion.getConnection();
            }
            catch (Exception)
            {
                throw;
                //throw new Exception(e.Message, e);
            }
        }


        public bool EjecutarUpdate(MySqlCommand comando, bool commit)
        {
            Conexion.BeginTransaction();
            bool realizado = false;
            try
            {
                comando.Connection = connection;
                
                realizado = comando.ExecuteNonQuery() > 0;
                if (realizado && commit)
                {
                    Conexion.Commit();
                }
            }
            catch (Exception)
            {
                Conexion.Rollback();
                throw;
            }

            return realizado;
        }

        public List<object> EjecutarConsulta(string sql, Type clase, string nombre)
        {
            List<object> objetos = null;
            MySqlDataReader sqlDataReader = null;
            try
            {
                comando = new MySqlCommand(sql, connection);
                if (!nombre.Equals(""))
                {
                    comando.Parameters.AddWithValue("@a1", nombre);
                }
                sqlDataReader = comando.ExecuteReader();
                if (sqlDataReader != null)
                {
                    objetos = new List<object>();
                    PropertyInfo[] properties = UtilSQL.ObtenerPropiedades(clase);
                    {
                        while (sqlDataReader.Read())
                        {
                            object obj = Activator.CreateInstance(clase);
                            foreach (var property in properties)
                            {
                                string valor = (String)sqlDataReader[property.Name].ToString();
                                property.SetValue(obj, Convert.ChangeType(valor, property.PropertyType), null);

                            }
                            objetos.Add(obj);
                        }
                    }
                }

            }
            catch (Exception)
            {
                throw;
            }
            finally
            {
                sqlDataReader.Close();
            }
            return objetos;
        }

        public void CloseConnection()
        {
            Conexion.CerrarConexion();
        }

        public class Conexion
        {
            private static MySqlConnection connection;
            private static MySqlTransaction transaction;

            /*  
             *  Abre la conexion con la base de datos
             */
            public static MySqlConnection getConnection()
            {
                if (connection == null)
                {
                    try
                    {
                        connection = new MySqlConnection();
                        connection.ConnectionString =
                            "Server=" + ConfigurationManager.AppSettings["servidor"].ToString()
                            + ";Database=" + ConfigurationManager.AppSettings["baseDatos"].ToString()
                            + ";Uid=" + ConfigurationManager.AppSettings["usuario"].ToString()
                            + ";Pwd=" + ConfigurationManager.AppSettings["password"].ToString() + ";";
                        connection.Open();
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }
                return connection;
            }

            public static void BeginTransaction()
            {
                if (transaction == null)
                {
                    transaction = connection.BeginTransaction();
                }
            }

            public static void Commit()
            {
                transaction.Commit();
                transaction = null;
            }

            public static void Rollback()
            {
                transaction.Rollback();
                transaction = null;
            }

            public static void CerrarConexion()
            {
                if (connection != null) connection.Close();
            }
        }
    }
}
