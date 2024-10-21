using System;
using System.Collections.Generic;

namespace LibreriaV2.Datos
{
    interface IAcceso<obj>
    {
        bool insertarMovil(obj objeto);
        bool borrarMovil(obj objeto);
        Object buscarMovil(String nombre);
        List<object> obtenerMoviles();
        bool modificarMovil(obj objeto);
    }

}
