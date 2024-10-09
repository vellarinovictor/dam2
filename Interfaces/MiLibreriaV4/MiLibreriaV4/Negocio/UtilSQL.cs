namespace MiLibreriaV4.Negocio
{
    class UtilSQL
    {
        public static String sqlInsertarLibro(TMovil obMovil)
        {
            return "INSERT INTO `tmovil`(`modelo`, `fabricante`, `marca`, `cargas`,`precio`, `coloruno`, `colordos`, `colortres`, `estado`) VALUES ('"
                    + obMovil.Modelo + "' , '" + obMovil.Fabricante + "' , '" + obMovil.Marca + "' , '"
                    + obMovil.NumeroCargas + "' , '" + obMovil.Precio + "' , '" + obMovil.Coloruno + "' , '" + obMovil.Colordos + "' , '"
                    + obMovil.Colortres + "' , '" + obMovil.Estado + "')";
        }

        public static String sqlBorrarLibro(String nombre)
        {
            return "DELETE FROM `tmovil` WHERE `modelo` = '" + nombre + "'";
        }

        public static String sqlBuscarLibro(String nombre)
        {
            return "SELECT * FROM `tmovil` WHERE `modelo` = '"
                    + nombre + "'";
        }

        public static String sqlObtenerLibros()
        {
            return "SELECT * FROM tmovil";

        }

        public static String sqlModificarMovil(TMovil obMovil)
        {
            return "UPDATE `tmovil` SET `modelo`= '" + obMovil.Modelo + "' ,`fabricante`= '" + obMovil.Fabricante
                    + "' ,`marca`= '" + obMovil.Marca + "' ,`cargas`= '" + obMovil.NumeroCargas + "' ,`precio`= '" + obMovil.Precio + "' ,`coloruno`= '"
                    + obMovil.Coloruno + "' ,`colordos`= '" + obMovil.Colordos + "' ,`colortres`= '"
                    + obMovil.Colortres + "' ,`estado`= '" + obMovil.Estado + "'  WHERE `modelo` = '"
                    + obMovil.Modelo + "'";
        }
    }
}