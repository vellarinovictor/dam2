using LibreriaV5_Final.Comun;
using LibreriaV5_Final.Modelo;
using LibreriaV5_Final.Negocio;
using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    public partial class Clientes : Form
    {
        private ControlAccesoDAO<object> control = new ControlAccesoDAO<object>();

        public Clientes() {
            InitializeComponent();
            ObtenerTodosLibros();
        }

        private void btnAlta_Click(object sender, System.EventArgs e)
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
                    if (control.Buscar(cliente.GetType(), cliente.CodCliente) != null)
                    {
                        MessageBox.Show(Mensajes.MSG_YAEXISTE_LIBRO);
                    }
                    else
                    {
                        control.Insertar(cliente);
                        lstClientes.Items.Add(cliente);
                        MessageBox.Show(Mensajes.MSG_INSERTADO_LIBRO);
                    }
                }
                lstClientes.ClearSelected();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnBaja_Click(object sender, System.EventArgs e)
        {
            try
            {
                if (lstClientes.SelectedItem != null)
                {
                    var result = MessageBox.Show(Mensajes.MSG_PREGUNTA_BORRAR, Mensajes.MSG_ATENCION, MessageBoxButtons.YesNoCancel, MessageBoxIcon.Asterisk);
                    //Borrado virtual
                    if (result == DialogResult.Yes)
                    {
                        if (control.BorradoVirtual(lstClientes.SelectedItem))
                        {
                            MessageBox.Show(Mensajes.MSG_BORRADO_VIRTUAL);
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                    else if (result == DialogResult.No)
                    {
                        if (control.Borrar(lstClientes.SelectedItem))
                        {
                            MessageBox.Show(Mensajes.MSG_BORRADO_LIBRO);
                            lstClientes.Items.Remove(lstClientes.SelectedItem);
                        }
                    }
                }
                else
                {
                    MessageBox.Show(Mensajes.MSG_SELECCIONAR_LIBRO);
                }
            } catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void btnModificar_Click(object sender, System.EventArgs e)
        {
            try
            {
                TCliente cliente = RecogerDatosPantalla();
                if (cliente != null)
                {
                    cliente.Borrado = ((TCliente)lstClientes.SelectedItem).Borrado;
                    if (control.Modificar(cliente))
                    {
                        lstClientes.Items.Remove(lstClientes.SelectedItem);
                        lstClientes.Items.Add(cliente);
                        MessageBox.Show(Mensajes.MSG_MODIFICADO_LIBRO);
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

        private void btnNuevo_Click(object sender, System.EventArgs e)
        {
            VaciarPantalla();
        }

        private void btnSalir_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }

       








        private void ObtenerTodosLibros()
        {
            try
            {
                List<object> clientes = new List<object>();
                foreach (TCliente item in control.Obtener(new TCliente().GetType()))
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



        private void RellenarCampos(TCliente sender)
        {
            txtNombre.Text = sender.Nombre;
            txtApellidos.Text = sender.Apellidos;
            txtDni.Text = sender.DNI;
            txtDireccion.Text = sender.Direccion;
            txtEmail.Text = sender.Email;
        }

        private TCliente RecogerDatosPantalla()
        {
            TCliente cliente = null;
            string nombre, apellidos, dni, direccion, email;
            nombre = txtNombre.Text;
            apellidos = txtApellidos.Text;
            dni = txtDni.Text;
            direccion = txtDireccion.Text;
            email = txtEmail.Text;
            cliente = new TCliente(nombre, apellidos, dni, direccion, email);
            return cliente;
        }

        private void VaciarPantalla()
        {
            txtNombre.Text = "";
            txtApellidos.Text = "";
            txtDni.Text = "";
            txtDireccion.Text = "";
            txtEmail.Text = "";
        }

        private void lstClientes_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (lstClientes.SelectedItem != null)
            {
                RellenarCampos((TCliente)lstClientes.SelectedItem);
            }
        }
    }
}
