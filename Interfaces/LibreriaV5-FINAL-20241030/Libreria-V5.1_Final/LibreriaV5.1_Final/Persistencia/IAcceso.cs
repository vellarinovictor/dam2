using System;
using System.Collections.Generic;

namespace LibreriaV5_1_Final.Persistencia
{
    interface IAcceso<obj>
    {
        bool Insertar(List<obj> objetos);
        bool Borrar(List<obj> objeto);
        bool BorradoVirtual(List<obj> objeto);
        Object BuscarOne(Type clase, String nombre);
        List<object> Buscar(Type clase, string campo, string busqueda);
        List<object> BuscarAll(Type clase);
        bool Modificar(List<obj> objetos);
    }

}
