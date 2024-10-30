using LibreriaV5_1_Final.Comun;
using LibreriaV5_1_Final.Negocio;
using LibreriaV5_1_Final.Persistencia;
using System;
using System.Windows.Forms;

namespace LibreriaV5_1_Final.Vista
{
    public partial class FrmPrincipal : Form
    {
        public FrmPrincipal()
        {
            InitializeComponent();
            try { 
            UtilFichero.RellenarDictionarySentencias();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void LibrosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new FrmLibro().ShowDialog(this);
        }

        private void InsertarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new FrmInsertarFacturas().ShowDialog(this);
        }

        private void EliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new FrmConsultarFacturas().ShowDialog(this);
        }

        private void ClientesToolStripMenuItem_Click(object sender, EventArgs e)
        {

            new FrmClientes().ShowDialog(this);
            
        }

        private void Principal_FormClosed(object sender, FormClosedEventArgs e)
        {
            try { 
            UtilFichero.EscribirDictionarySentenciasFichero();
                new ControlAccesoDAO<Object>().CerrarAplicacion();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
