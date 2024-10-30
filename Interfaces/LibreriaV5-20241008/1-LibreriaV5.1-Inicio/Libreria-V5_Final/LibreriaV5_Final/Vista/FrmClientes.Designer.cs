using System;
using System.Windows.Forms;

namespace LibreriaV5_Final.Vista
{
    partial class Clientes
    {
        private TextBox txtNombre;
        private ContextMenuStrip contextMenuStrip1;
        private System.ComponentModel.IContainer components = null;
        private TextBox txtApellidos;
        private TextBox txtDni;
        private TextBox txtDireccion;
        private TextBox txtEmail;
        private Label label1;


        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.txtApellidos = new System.Windows.Forms.TextBox();
            this.txtDni = new System.Windows.Forms.TextBox();
            this.txtDireccion = new System.Windows.Forms.TextBox();
            this.txtEmail = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.lstClientes = new System.Windows.Forms.ListBox();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnSalir = new System.Windows.Forms.Button();
            this.btnNuevo = new System.Windows.Forms.Button();
            this.btnModificar = new System.Windows.Forms.Button();
            this.btnBaja = new System.Windows.Forms.Button();
            this.btnAlta = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtNombre
            // 
            this.txtNombre.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtNombre.Location = new System.Drawing.Point(166, 98);
            this.txtNombre.Multiline = true;
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(218, 37);
            this.txtNombre.TabIndex = 0;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // txtApellidos
            // 
            this.txtApellidos.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtApellidos.Location = new System.Drawing.Point(166, 161);
            this.txtApellidos.Multiline = true;
            this.txtApellidos.Name = "txtApellidos";
            this.txtApellidos.Size = new System.Drawing.Size(218, 37);
            this.txtApellidos.TabIndex = 2;
            // 
            // txtDni
            // 
            this.txtDni.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtDni.Location = new System.Drawing.Point(166, 231);
            this.txtDni.Multiline = true;
            this.txtDni.Name = "txtDni";
            this.txtDni.Size = new System.Drawing.Size(218, 37);
            this.txtDni.TabIndex = 3;
            // 
            // txtDireccion
            // 
            this.txtDireccion.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtDireccion.Location = new System.Drawing.Point(166, 302);
            this.txtDireccion.Multiline = true;
            this.txtDireccion.Name = "txtDireccion";
            this.txtDireccion.Size = new System.Drawing.Size(218, 37);
            this.txtDireccion.TabIndex = 4;
            // 
            // txtEmail
            // 
            this.txtEmail.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F);
            this.txtEmail.Location = new System.Drawing.Point(166, 377);
            this.txtEmail.Multiline = true;
            this.txtEmail.Name = "txtEmail";
            this.txtEmail.Size = new System.Drawing.Size(218, 37);
            this.txtEmail.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 22F);
            this.label1.Location = new System.Drawing.Point(338, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(200, 42);
            this.label1.TabIndex = 6;
            this.label1.Text = "CLIENTES";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 19F);
            this.label2.Location = new System.Drawing.Point(12, 98);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(132, 37);
            this.label2.TabIndex = 7;
            this.label2.Text = "Nombre";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 19F);
            this.label3.Location = new System.Drawing.Point(12, 161);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(147, 37);
            this.label3.TabIndex = 8;
            this.label3.Text = "Apellidos";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 19F);
            this.label4.Location = new System.Drawing.Point(12, 231);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(72, 37);
            this.label4.TabIndex = 9;
            this.label4.Text = "DNI";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 19F);
            this.label5.Location = new System.Drawing.Point(12, 302);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(150, 37);
            this.label5.TabIndex = 10;
            this.label5.Text = "Dirección";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 19F);
            this.label6.Location = new System.Drawing.Point(12, 377);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(97, 37);
            this.label6.TabIndex = 11;
            this.label6.Text = "Email";
            // 
            // lstClientes
            // 
            this.lstClientes.FormattingEnabled = true;
            this.lstClientes.ItemHeight = 16;
            this.lstClientes.Location = new System.Drawing.Point(440, 98);
            this.lstClientes.Name = "lstClientes";
            this.lstClientes.Size = new System.Drawing.Size(417, 228);
            this.lstClientes.TabIndex = 12;
            this.lstClientes.SelectedIndexChanged += new System.EventHandler(this.lstClientes_SelectedIndexChanged);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.btnSalir);
            this.panel1.Controls.Add(this.btnNuevo);
            this.panel1.Controls.Add(this.btnModificar);
            this.panel1.Controls.Add(this.btnBaja);
            this.panel1.Controls.Add(this.btnAlta);
            this.panel1.Location = new System.Drawing.Point(440, 366);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(417, 117);
            this.panel1.TabIndex = 13;
            // 
            // btnSalir
            // 
            this.btnSalir.Location = new System.Drawing.Point(226, 57);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(116, 48);
            this.btnSalir.TabIndex = 4;
            this.btnSalir.Text = "Salir";
            this.btnSalir.UseVisualStyleBackColor = true;
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // btnNuevo
            // 
            this.btnNuevo.Location = new System.Drawing.Point(76, 57);
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(116, 48);
            this.btnNuevo.TabIndex = 3;
            this.btnNuevo.Text = "Nuevo";
            this.btnNuevo.UseVisualStyleBackColor = true;
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnModificar
            // 
            this.btnModificar.Location = new System.Drawing.Point(298, 3);
            this.btnModificar.Name = "btnModificar";
            this.btnModificar.Size = new System.Drawing.Size(116, 48);
            this.btnModificar.TabIndex = 2;
            this.btnModificar.Text = "Modificar";
            this.btnModificar.UseVisualStyleBackColor = true;
            this.btnModificar.Click += new System.EventHandler(this.btnModificar_Click);
            // 
            // btnBaja
            // 
            this.btnBaja.Location = new System.Drawing.Point(153, 3);
            this.btnBaja.Name = "btnBaja";
            this.btnBaja.Size = new System.Drawing.Size(116, 48);
            this.btnBaja.TabIndex = 1;
            this.btnBaja.Text = "Baja";
            this.btnBaja.UseVisualStyleBackColor = true;
            this.btnBaja.Click += new System.EventHandler(this.btnBaja_Click);
            // 
            // btnAlta
            // 
            this.btnAlta.Location = new System.Drawing.Point(3, 3);
            this.btnAlta.Name = "btnAlta";
            this.btnAlta.Size = new System.Drawing.Size(116, 48);
            this.btnAlta.TabIndex = 0;
            this.btnAlta.Text = "Alta";
            this.btnAlta.UseVisualStyleBackColor = true;
            this.btnAlta.Click += new System.EventHandler(this.btnAlta_Click);
            // 
            // Clientes
            // 
            this.ClientSize = new System.Drawing.Size(869, 525);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.lstClientes);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtEmail);
            this.Controls.Add(this.txtDireccion);
            this.Controls.Add(this.txtDni);
            this.Controls.Add(this.txtApellidos);
            this.Controls.Add(this.txtNombre);
            this.Name = "Clientes";
            this.panel1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        

        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private ListBox lstClientes;
        private Panel panel1;
        private Button btnSalir;
        private Button btnNuevo;
        private Button btnModificar;
        private Button btnBaja;
        private Button btnAlta;
    }
}

