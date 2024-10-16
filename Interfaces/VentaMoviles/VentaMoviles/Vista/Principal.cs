using VentaMoviles.Negocio;

namespace VentaMoviles
{
    public partial class Principal : Form
    {
        private AccesoMovil acceso = new AccesoMovil();
        public Principal()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                List<object> moviles = acceso.obtenerMoviles();
                foreach (TMovil movil in moviles)
                {
                    listaMoviles.Items.Add(movil.Modelo);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        
    }
}
