using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaMoviles.Negocio
{
    public class TMovil
    {
        public string Modelo { get; set; }
        public string Marca { get; set; }
        public string Precio { get; set; }
        public string Extrauno { get; set; }
        public string Extrados { get; set; }
        public string Extratres { get; set; }
        public string Estado { get; set; }

        public TMovil(string modelo, string marca, string precio, string extrauno, string extrados, string extratres, string estado)
        {
            this.Modelo = modelo;
            this.Marca = marca;
            this.Precio = precio;
            this.Extrauno = extrauno;
            this.Extrados = extrados;
            this.Extratres = extratres;
            this.Estado = estado;
        }

        public TMovil() { }
    }
}
