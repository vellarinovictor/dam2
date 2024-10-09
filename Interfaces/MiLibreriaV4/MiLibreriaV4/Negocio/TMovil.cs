using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MiLibreriaV4.Negocio
{
    public class TMovil
    {
        public string CodMovil { get; set; }
        public string Fabricante { get; set; }
        public string Modelo { get; set; }
        public string Marca { get; set; }
        public string NumeroCargas { get; set; }
        public string Precio { get; set; }
        public string Coloruno { get; set; }
        public string Colordos { get; set; }
        public string Colortres { get; set; }
        public string Estado { get; set; }

        public TMovil(string codMovil, string fabricante, string modelo, string marca, string cargas, string precio, string coloruno, string colordos, string colortres, string estado)
        {
            //this.CodMovil = codMovil;
            this.Fabricante = fabricante;
            this.Modelo = modelo;
            this.Marca = marca;
            this.NumeroCargas = cargas;
            this.Precio = precio;
            this.Coloruno = coloruno;
            this.Colordos = colordos;
            this.Colortres = colortres;
            this.Estado = estado;
        }
        public TMovil(string fabricante, string modelo, string marca, string cargas, string precio, string coloruno, string colordos, string colortres, string estado)
        {
            this.Fabricante = fabricante;
            this.Modelo = modelo;
            this.Marca = marca;
            this.NumeroCargas = cargas;
            this.Precio = precio;
            this.Coloruno = coloruno;
            this.Colordos = colordos;
            this.Colortres = colortres;
            this.Estado = estado;
        }
        public TMovil() { }

        public override string ToString()
        {
            return CodMovil + ": " + Modelo.ToUpper();
        }
    }
}
