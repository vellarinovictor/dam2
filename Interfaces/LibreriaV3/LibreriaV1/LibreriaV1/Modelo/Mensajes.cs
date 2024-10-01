using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaV2.Modelo
{
    class Mensajes
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
    }

    public static string msgDelQuest()
    {
        lblMensaje.Text(QUEST_BORRAR);
    }
    public static string msgInsMsg()
    {
        lblMensaje.Text(MSG_INSERTADO);
    }
    public static string msgDelete()
    {
        lblMensaje.Text(MSG_BORRADO);
    }
    public static string msgModi()
    {
        lblMensaje.Text(MSG_MODIFICADO);
    }
    public static string msgAlrEx()
    {
        lblMensaje.Text(MSG_YAEXISTE);
    }
    public static string msgEmpFie()
    {
        lblMensaje.Text(MSG_CAMPOSVACIOS);
    }
    public static string msgPag()
    {
        lblMensaje.Text(MSG_PAGINAS);
    }
    public static string msgNotFound()
    {
        lblMensaje.Text(MSG_NO_ENCONTRADO);
    }
    public static string msgNoChg()
    {
        lblMensaje.Text(MSG_NO_CAMBIOS);
    }
}
