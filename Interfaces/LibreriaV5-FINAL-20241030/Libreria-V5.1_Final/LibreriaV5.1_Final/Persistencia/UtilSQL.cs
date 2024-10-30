using MySql.Data.MySqlClient;
using System;
using System.Reflection;
using System.Text;
//using LibreriaV5_Final.Persistencia;

namespace LibreriaV5_1_Final.Persistencia
{
    public class UtilSQL
    {
        private static StringBuilder sql = new StringBuilder();

        public static string SqlInsertar(object objeto)
        {
            sql.Clear();
            sql.Append("INSERT INTO " + objeto.GetType().Name.ToLower() + " ( ");
            RellenarSql(objeto);
            return sql.ToString();
        }

        public static string SqlModificar(Object objeto)
        {
            sql.Clear();
            sql.Append("UPDATE " + objeto.GetType().Name.ToLower() + " SET ");
            RellenarSql(objeto);
            return sql.ToString();
        }

        public static string SqlBuscar(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE " + ObtenerClave(clase) + " = @a1 ");
            return sql.ToString();
        }

        public static string SqlBorrar(Object objeto)
        {
            sql.Clear();
            sql.Append("DELETE FROM " + objeto.GetType().Name.ToLower() + " WHERE " + ObtenerClave(objeto.GetType()) + " = @1 ");
            return sql.ToString();
        }

        public static string SqlObtener(Type clase)
        {
            sql.Clear();
            sql.Append("SELECT * FROM " + clase.Name.ToLower() + " WHERE Borrado LIKE 0");
            return sql.ToString();
        }

        public static PropertyInfo[] ObtenerPropiedades(Type clase)
        {
            return clase.GetProperties();
        }

        public static string GenerarCodigo(Type clase)
        {
            String codigoGenerado;

            string codigo = new AccesoDAO<Object>().ObtenerCodigo(clase);
            if (codigo.Equals(""))
            {
                codigoGenerado = "cod001";
            }
            else
            {
                int indice = int.Parse(codigo.Substring(3)) + 1;
                if (indice >= 100)
                    codigoGenerado = "cod" + indice;
                else if (indice >= 10)
                    codigoGenerado = "cod0" + indice;
                else
                    codigoGenerado = "cod00" + indice;
            }
            return codigoGenerado;
        }

        public static string ObtenerClave(Type clase)
        {
            return "Cod" + clase.Name.ToString().Substring(1);
        }

        //
        //********** MÉTODOS PRIVADOS DE LA CLASE UtilSQL*************************
        //

        public static MySqlCommand Parametrizar(Object objeto, String sql)
        {
            MySqlCommand comando = new MySqlCommand(sql);
            PropertyInfo[] propertyInfo = objeto.GetType().GetProperties();
            int index = 1;

            if (sql.Contains("DELETE"))
            {
                comando.Parameters.AddWithValue("@1", propertyInfo[0].GetValue(objeto));
            }
            else
            {
                for (int i = 0; i < propertyInfo.Length; i++)
                {
                    comando.Parameters.AddWithValue("@" + index++, propertyInfo[i].GetValue(objeto));
                }
                if (sql.Contains("UPDATE"))
                {
                    comando.Parameters.AddWithValue("@" + index, propertyInfo[0].GetValue(objeto));
                }
            }
            return comando;
        }

        private static void RellenarSql(Object objeto)
        {
            bool update = sql.ToString().Contains("INSERT") ? false : true;
            int index = 1;
            PropertyInfo[] list = ObtenerPropiedades(objeto.GetType());
            StringBuilder cadena = new StringBuilder(" ) VALUES ( ");

            foreach (var item in list)
            {
                if (update)
                {
                    sql.Append(item.Name + " = @" + (index++) + " , ");
                }
                else
                {
                    sql.Append(item.Name + ", ");
                    cadena.Append("@" + (index++) + " , ");
                }
            }
            if (update)
            {
                sql.Remove(sql.Length - 2, 2);
                sql.Append("WHERE " + ObtenerClave(objeto.GetType()) + " = @" + index);
            }
            else
            {
                sql.Remove(sql.Length - 2, 2);
                sql.Append(cadena.Remove(cadena.Length - 2, 2) + " ) ");
            }
        }

    }
}
