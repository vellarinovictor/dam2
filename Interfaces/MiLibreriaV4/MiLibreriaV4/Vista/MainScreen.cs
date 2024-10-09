using MiLibreriaV4.Negocio;
using MiLibreriaV4.General;

namespace MiLibreriaV4
{
    public partial class MainScreen : Form
    {

        private AccesoLibro acceso = new AccesoLibro();
        public MainScreen()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            List<Object> libros = acceso.obtenerMoviles();

            try
            {   
                libros = acceso.obtenerMoviles();
                foreach (TMovil libro in libros)
                {
                    lstLibros.Items.Add(libro.Modelo);
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
                    lstLibros.Items.Add(txtTitulo.Text);
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
                if (!(lstLibros.SelectedIndex == -1))
                {
                    if (acceso.borrarMovil(RecogerDatosPantalla()))
                    {
                        lstLibros.Items.Remove(lstLibros.SelectedItem.ToString());
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
                if (lstLibros.SelectedItem != null)
                {
                    EnviarDatosAPantalla((TMovil)acceso.buscarMovil (lstLibros.SelectedItem.ToString()));
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }


        private void txtPaginas_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
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

        /*METODOS PRIVADOS DE LA CLASE*/
        private void VaciarPantalla()
        {
            txtAutor.Text = "";
            txtMensaje.Text = "";
            txtPaginas.Text = "";
            txtPrecio.Text = "";
            txtTitulo.Text = "";
            rbReedicion.Checked = false;
            chkCartone.Checked = false;
            chkRustica.Checked = false;
            chkTapaDura.Checked = false;
            cbxTemas.SelectedIndex = 0;
        }

        private TMovil RecogerDatosPantalla()
        {
            TMovil libro = null;
            string titulo, autor, paginas, precio, formatoUno, formatoDos, formatoTres, estado, tema;
            titulo = txtTitulo.Text;
            autor = txtAutor.Text;
            paginas = txtPaginas.Text;
            precio = txtPrecio.Text.Replace(".", ",");
            precio = precio.Replace("€", "");
            precio = precio.Trim();
            formatoUno = chkCartone.Checked ? chkCartone.Text : "N/A";
            formatoDos = chkRustica.Checked ? chkRustica.Text : "N/A";
            formatoTres = chkTapaDura.Checked ? chkTapaDura.Text : "N/A";
            tema = cbxTemas.SelectedItem.ToString();
            if (rbNovedad.Checked)
            {
                estado = "novedad";
            }
            else
            {
                estado = "reedicion";
            }

            if (titulo.Count() != 0 && paginas.Count() != 0 && titulo.Count() != 0 && precio.Count() != 0)
            {
                libro = new TMovil(autor, titulo, tema, paginas, precio, formatoUno, formatoDos, formatoTres, estado);
            }
            return libro;
        }

        private void EnviarDatosAPantalla(TMovil sender)
        {
            txtAutor.Text = sender.Fabricante;
            txtPaginas.Text = sender.NumeroCargas;
            txtPrecio.Text = sender.Precio + " €";
            txtTitulo.Text = sender.Modelo;
            cbxTemas.Text = sender.Marca;
            if (sender.Estado.Equals("reedicion"))
            {
                rbReedicion.Checked = true;
                rbNovedad.Checked = false;
            }
            else
            {
                rbNovedad.Checked = true;
                rbReedicion.Checked = false;
            }

            chkCartone.Checked = sender.Coloruno.Equals("Cartoné") ? true : false;
            chkRustica.Checked = sender.Colordos.Equals("Rústica") ? true : false; ;
            chkTapaDura.Checked = sender.Colortres.Equals("Tapa dura") ? true : false;
        }
    }
}
