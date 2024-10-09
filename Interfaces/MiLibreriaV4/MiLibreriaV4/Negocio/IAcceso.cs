namespace MiLibreriaV4.Negocio
{
    internal interface IAcceso<obj>
    {
        bool insertarMovil(obj objeto);
        bool borrarMovil(obj objeto);
        Object buscarMovil(String nombre);
        List<object> obtenerMoviles();
        bool modificarMovil(obj objeto);
    }
}