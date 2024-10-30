using LibreriaV5_1_Final.Comun;
using LibreriaV5_1_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace LibreriaV5_1_Final.Vista
{
    public partial class FrmClientes : Form
    {

        private ControlAccesoDAO<Object> control = new ControlAccesoDAO<Object>();

        public FrmClientes()
        {
            InitializeComponent();
            ObtenerTodosClientes();
        }

        private void BtnNuevo_Click(object sender, EventArgs e)
        {
            VaciarPantalla();
        }

        private void BtnAlta_Click(object sender, EventArgs e)
        {
            TCliente cliente;
            try
            {
                if ((cliente = RecogerDatosPantalla()) == null)
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
                else
                {
                    if (control.BuscarOne(cliente.GetType(), cliente.CodCliente) != null)
                    {
                        txtMensaje.Text = Mensajes.MSG_YAEXISTE_CLIENTE;
                    }
                    else
                    {
                        List<Object> clientes = new List<object>();
                        clientes.Add(cliente);
                        control.Insertar(clientes);
                        lstClientes.Items.Add(cliente);
                        txtMensaje.Text = Mensajes.MSG_INSERTADO_CLIENTE;
                    }
                }
                lstClientes.ClearSelected();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnBaja_Click(object sender, EventArgs e)
        {
            try
            {
                if (lstClientes.SelectedItem != null)
                {

                    var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNoCancel, MessageBoxIcon.Asterisk);
                    //Borrado virtual
                    List<Object> clientes = new List<object>();
                    clientes.Add(lstClientes.SelectedItem);
                    if (result == DialogResult.Yes)
                    {
                        if (control.BorradoVirtual(clientes))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_VIRTUAL;
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                    else if (result == DialogResult.No)
                    {
                        if (control.Borrar(clientes))
                        {
                            txtMensaje.Text = Mensajes.MSG_BORRADO_CLIENTE;
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_SELECCIONAR_CLIENTE);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnModificar_Click(object sender, EventArgs e)
        {
            try
            {
                TCliente cliente = RecogerDatosPantalla();
                if (cliente != null)
                {
                    cliente.Borrado = ((TCliente)lstClientes.SelectedItem).Borrado;
                    List<Object> clientes = new List<object>();
                    clientes.Add(cliente);
                    if (control.Modificar(clientes))
                    {
                        lstClientes.Items.Insert(lstClientes.SelectedIndex, cliente);
                        lstClientes.Items.Remove(lstClientes.SelectedItem);
                        txtMensaje.Text = Mensajes.MSG_MODIFICADO_CLIENTE;
                        VaciarPantalla();
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_CAMPOSVACIOS);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void BtnSalir_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void LstClientes_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstClientes.SelectedItem != null)
            {
                RellenarCampos((TCliente)lstClientes.SelectedItem);
            }
        }

        //---------------------METODOS PRIVADOS de la clase FrmCliente-------------------//

        private TCliente RecogerDatosPantalla()
        {
            TCliente cliente = null;
            string codCliente, nombre, apellidos, dni, direccion, email;
            nombre = txtNombre.Text;
            apellidos = txtApellidos.Text;
            dni = txtDNI.Text;
            direccion = txtDireccion.Text;
            email = txtEmail.Text;

            if (nombre.Count() != 0 && apellidos.Count() != 0 && dni.Count() != 0 && direccion.Count() != 0 && email.Count() != 0)
            {
                if (((TCliente)lstClientes.SelectedItem) == null)
                    try
                {
                    cliente = new TCliente(nombre, apellidos, dni, direccion, email);
                }
                catch (Exception ex) { MessageBox.Show(ex.Message); }
                else
                {
                    codCliente = ((TCliente)lstClientes.SelectedItem).CodCliente;
                    cliente = new TCliente(codCliente, nombre, apellidos, dni, direccion, email);
                }
            }
            return cliente;
        }

        private void ObtenerTodosClientes()
        {
            try
            {
                List<object> clientes = new List<object>();
                foreach (TCliente item in control.BuscarAll(new TCliente().GetType()))
                {
                    if (item.Borrado.Equals("0"))
                    {
                        lstClientes.Items.Add(item);
                    }
                }
                lstClientes.ClearSelected();
                VaciarPantalla();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void VaciarPantalla()
        {
            txtNombre.Text = "";
            txtApellidos.Text = "";
            txtDireccion.Text = "";
            txtDNI.Text = "";
            txtEmail.Text = "";
            //txtMensaje.Text = "";
            lstClientes.ClearSelected();

        }

        private void RellenarCampos(TCliente cliente)
        {
            txtNombre.Text = cliente.Nombre;
            txtApellidos.Text = cliente.Apellidos;
            txtDireccion.Text = cliente.Direccion;
            txtEmail.Text = cliente.Email;
            txtDNI.Text = cliente.DNI;

        }
    }
}
