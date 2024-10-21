using LibreriaV2.Datos;
using VentaMoviles.Negocio;
using VentaMoviles.Vista;

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

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void btnAlta_Click(object sender, EventArgs e)
        {
            try
            {
                if (acceso.insertarMovil(RecogerDatosPantalla()))
                {
                    listaMoviles.Items.Add(txtModelo.Text);
                    MessageBox.Show(Mensajes.MSG_INSERTADO);
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_YAEXISTE);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (!(listaMoviles.SelectedIndex == -1))
                {
                    if (acceso.borrarMovil(RecogerDatosPantalla()))
                    {
                        listaMoviles.Items.Remove(listaMoviles.SelectedItem.ToString());
                        MessageBox.Show(Mensajes.MSG_BORRADO);
                    }
                    else
                    {
                        MessageBox.Show(Mensajes.MSG_NO_ENCONTRADO);
                    }
                    VaciarPantalla();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnModificar_Click(object sender, EventArgs e)
        {
            try
            {
                if (acceso.modificarMovil(RecogerDatosPantalla()))
                {
                    MessageBox.Show(Mensajes.MSG_MODIFICADO);
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_NO_ENCONTRADO);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void lstLibros_SelectedIndexChanged(object sender, EventArgs e)
        {
            try
            {
                if (listaMoviles.SelectedItem != null)
                {
                    EnviarDatosAPantalla((TMovil)acceso.buscarMovil(listaMoviles.SelectedItem.ToString()));
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void txtPrecio_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) &&
               (e.KeyChar != '.') && (e.KeyChar != ','))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
            if ((e.KeyChar == ',') && ((sender as TextBox).Text.IndexOf(',') > -1))
            {
                e.Handled = true;
            }
        }




        //*****************************  MÉTODOS  PRIVADOS INTERNOS DE LA CLASE  ******************

        /******************************************************************************************
         * Metodo para recoger los datos
         * Se encarga de montar un libro a través de los datos que introduces en la ventana gráfica
         ******************************************************************************************/

        private TMovil RecogerDatosPantalla()
        {
            TMovil movil = null;
            string modelo, marca, precio, extraUno, extraDos, extraTres, estado, tema;
            modelo = txtModelo.Text;

            precio = txtPrecio.Text.Replace(".", ",");
            precio = precio.Replace("€", "");
            precio = precio.Trim();
            extraUno = chkNfc.Checked ? chkNfc.Text : "N/A";
            extraDos = chkCarcasa.Checked ? chkCarcasa.Text : "N/A";
            extraTres = chkProtector.Checked ? chkProtector.Text : "N/A";
            marca = cbxMarcas.SelectedItem.ToString();
            if (rb128.Checked)
            {
                estado = "128gb";
            }
            else
            {
                estado = "256gb";
            }

            if (modelo.Count() != 0 && precio.Count() != 0 && modelo.Count() != 0 && precio.Count() != 0)
            {
                movil = new TMovil(modelo, marca, precio, extraUno, extraDos, extraTres, estado);
            }
            return movil;
        }
        /*********************************************************************************************
	     * Pasamos por parametro un libro y este método se encargará de mostrarnos en la parte gráfica
	     * todo el contenido del libro.
	     *********************************************************************************************/
        private void EnviarDatosAPantalla(TMovil sender)
        {
            txtModelo.Text = sender.Modelo;
            txtPrecio.Text = sender.Precio + " €";
            cbxMarcas.Text = sender.Marca;
            if (sender.Estado.Equals("256gb"))
            {
                rb256.Checked = true;
                rb128.Checked = false;
            }
            else
            {
                rb128.Checked = true;
                rb256.Checked = false;
            }

            chkNfc.Checked = sender.Extrauno.Equals("NFC") ? true : false;
            chkCarcasa.Checked = sender.Extrados.Equals("Carcasa") ? true : false; ;
            chkProtector.Checked = sender.Extratres.Equals("Protector") ? true : false;
        }

        /*************************************************************************************
         * Método encargado de limpiar los campos de la pantalla
         * ***********************************************************************************/

        private void VaciarPantalla()
        {
            txtModelo.Text = "";
            txtPrecio.Text = "";
            rb256.Checked = false;
            chkNfc.Checked = false;
            chkCarcasa.Checked = false;
            chkProtector.Checked = false;
            cbxMarcas.SelectedIndex = 0;
        }
    }
}
