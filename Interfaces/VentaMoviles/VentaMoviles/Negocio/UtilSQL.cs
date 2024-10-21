using VentaMoviles.Negocio;

namespace LibreriaV2.Datos
{
    class UtilSQL
    {
        public static String sqlInsertarMovil(TMovil obMovil)
        {
            return "INSERT INTO `tmovil`(`modelo`, `marca`, `precio`, `extrauno`, `extrados`, `extratres`, `estado`) VALUES ('"
                    + obMovil.Modelo + "' , '" + obMovil.Marca + "' , '" + obMovil.Precio + "' , '" + obMovil.Extrauno + "' , '" + obMovil.Extrados + "' , '"
                    + obMovil.Extratres + "' , '" + obMovil.Estado + "')";
        }

        public static String sqlBorrarMovil(String nombre)
        {
            return "DELETE FROM `tmovil` WHERE `modelo` = '" + nombre + "'";
        }

        public static String sqlBuscarMovil(String nombre)
        {
            return "SELECT * FROM `tmovil` WHERE `modelo` = '"
                    + nombre + "'";
        }

        public static String sqlObtenerMoviles()
        {
            return "SELECT * FROM tmovil";

        }

        public static String sqlModificarMovil(TMovil obMovil)
        {
            return "UPDATE `tmovil` SET `modelo`= '" + obMovil.Modelo + "' ,`marca`= '" + obMovil.Marca
                    + "' ,`precio`= '" + obMovil.Precio + "' ,`extrauno`= '"
                    + obMovil.Extrauno + "' ,`extrados`= '" + obMovil.Extrados + "' ,`extratres`= '"
                    + obMovil.Extratres + "' ,`estado`= '" + obMovil.Estado + "'  WHERE `modelo` = '"
                    + obMovil.Modelo + "'";
        }
    }
}
