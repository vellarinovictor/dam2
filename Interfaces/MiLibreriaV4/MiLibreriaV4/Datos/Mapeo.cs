
using System.Reflection;

namespace MiLibreriaV4.Datos
{
    internal class Mapeo
    {
        internal static List<string> ObtenerNombrePropiedades(object objeto)
        {
            List<String> lista = new List<string>();
            PropertyInfo[] ee = objeto.GetType().GetProperties();
            foreach (PropertyInfo info in objeto.GetType().GetProperties())
            {
                lista.Add(info.Name);
            }
            return lista;
        }
    }
}