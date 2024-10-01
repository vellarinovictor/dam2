using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace LibreriaV3._1.Modelo
{
    static class Mensajes
    {
        public static String QUEST_BORRAR = "¿Deseas borrar el registro?";
        public static String MSG_INSERTADO = "Libro insertado correctamente";
        public static String MSG_BORRADO = "Libro borrado correctamente";
        public static String MSG_MODIFICADO = "Libro modificado correctamente";
        public static String MSG_YAEXISTE = "Ese libro ya existe";
        public static String MSG_CAMPOSVACIOS = "Debe rellenar los campos";
        public static String MSG_PAGINAS = "Número de páginas erróneo";
        public static String MSG_NO_ENCONTRADO = "Libro no encontrado";
        public static String MSG_NO_CAMBIOS = "No se ha realizado ningún cambio";

        public static string GetQuestBorrar()
        {
            return QUEST_BORRAR;
        }

        public static string GetMsgInsertado()
        {
            return MSG_INSERTADO;
        }

        public static string GetMsgBorrado()
        {
            return MSG_BORRADO;
        }

        public static string GetMsgModificado()
        {
            return MSG_MODIFICADO;
        }

        public static string GetMsgYaExiste()
        {
            return MSG_YAEXISTE;
        }

        public static string GetMsgCamposVacios()
        {
            return MSG_CAMPOSVACIOS;
        }

        public static string GetMsgPaginas()
        {
            return MSG_PAGINAS;
        }

        public static string GetMsgNoEncontrado()
        {
            return MSG_NO_ENCONTRADO;
        }

        public static string GetMsgNoCambios()
        {
            return MSG_NO_CAMBIOS;
        }
    }


}
