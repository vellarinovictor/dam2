using VentaMoviles.Negocio;

namespace LibreriaV2.Datos
{
    public class AccesoMovil : AccesoBD , IAcceso<TMovil>
    {

        public Boolean insertarMovil(TMovil obMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlInsertarMovil((TMovil)obMovil));
            }
            catch (Exception e)
            {
                throw;
            }

        }
        public Boolean borrarMovil(TMovil obMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlBorrarMovil(obMovil.Modelo));
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public object buscarMovil(string nombre)
        {

            try
            {
                return ejecutarConsulta(UtilSQL.sqlBuscarMovil(nombre), new TMovil()).First();
            }
            catch (Exception e)
            {
                throw;
            }
        }

        public List<object> obtenerMoviles()
        {

            try
            {
                return ejecutarConsulta(UtilSQL.sqlObtenerMoviles(), new TMovil());
            }
            catch (Exception e)
            {
                throw;
            }
        }


        public Boolean modificarMovil(TMovil obMovil)
        {
            try
            {
                return ejecutarUpdate(UtilSQL.sqlModificarMovil(obMovil));
            }
            catch (Exception e)
            {
                throw;
            }
        }

    }
}
