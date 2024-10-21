namespace VentaMoviles
{
    partial class Principal
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            textBox1 = new TextBox();
            txtModelo = new TextBox();
            txtPrecio = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            Almacenamiento = new GroupBox();
            rb256 = new RadioButton();
            rb128 = new RadioButton();
            Extra = new GroupBox();
            chkProtector = new CheckBox();
            chkCarcasa = new CheckBox();
            chkNfc = new CheckBox();
            listaMoviles = new ListBox();
            panel1 = new Panel();
            btnSalir = new Button();
            btnNuevo = new Button();
            btnModificar = new Button();
            btnBaja = new Button();
            btnAlta = new Button();
            cbxMarcas = new ComboBox();
            Almacenamiento.SuspendLayout();
            Extra.SuspendLayout();
            panel1.SuspendLayout();
            SuspendLayout();
            // 
            // textBox1
            // 
            textBox1.BackColor = SystemColors.Highlight;
            textBox1.ForeColor = SystemColors.ActiveCaptionText;
            textBox1.Location = new Point(242, 28);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(241, 27);
            textBox1.TabIndex = 0;
            textBox1.Text = "Venta de Moviles";
            textBox1.TextAlign = HorizontalAlignment.Center;
            // 
            // txtModelo
            // 
            txtModelo.Font = new Font("Segoe UI", 13F);
            txtModelo.Location = new Point(181, 85);
            txtModelo.Multiline = true;
            txtModelo.Name = "txtModelo";
            txtModelo.Size = new Size(188, 43);
            txtModelo.TabIndex = 1;
            // 
            // txtPrecio
            // 
            txtPrecio.Font = new Font("Segoe UI", 13F);
            txtPrecio.Location = new Point(181, 191);
            txtPrecio.Multiline = true;
            txtPrecio.Name = "txtPrecio";
            txtPrecio.Size = new Size(188, 41);
            txtPrecio.TabIndex = 3;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F);
            label1.Location = new Point(17, 89);
            label1.Name = "label1";
            label1.Size = new Size(85, 28);
            label1.TabIndex = 6;
            label1.Text = "Modelo:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F);
            label2.Location = new Point(17, 142);
            label2.Name = "label2";
            label2.Size = new Size(70, 28);
            label2.TabIndex = 7;
            label2.Text = "Marca:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 12F);
            label3.Location = new Point(17, 195);
            label3.Name = "label3";
            label3.Size = new Size(70, 28);
            label3.TabIndex = 8;
            label3.Text = "Precio:";
            // 
            // Almacenamiento
            // 
            Almacenamiento.Controls.Add(rb256);
            Almacenamiento.Controls.Add(rb128);
            Almacenamiento.Location = new Point(17, 261);
            Almacenamiento.Name = "Almacenamiento";
            Almacenamiento.Size = new Size(142, 150);
            Almacenamiento.TabIndex = 9;
            Almacenamiento.TabStop = false;
            Almacenamiento.Text = "Almacenamiento";
            // 
            // rb256
            // 
            rb256.AutoSize = true;
            rb256.Location = new Point(23, 56);
            rb256.Name = "rb256";
            rb256.Size = new Size(73, 24);
            rb256.TabIndex = 1;
            rb256.Text = "256GB";
            rb256.UseVisualStyleBackColor = true;
            // 
            // rb128
            // 
            rb128.AutoSize = true;
            rb128.Checked = true;
            rb128.Location = new Point(24, 26);
            rb128.Name = "rb128";
            rb128.Size = new Size(73, 24);
            rb128.TabIndex = 0;
            rb128.TabStop = true;
            rb128.Text = "128GB";
            rb128.UseVisualStyleBackColor = true;
            // 
            // Extra
            // 
            Extra.Controls.Add(chkProtector);
            Extra.Controls.Add(chkCarcasa);
            Extra.Controls.Add(chkNfc);
            Extra.Location = new Point(227, 261);
            Extra.Name = "Extra";
            Extra.Size = new Size(142, 150);
            Extra.TabIndex = 10;
            Extra.TabStop = false;
            Extra.Text = "Extras";
            // 
            // chkProtector
            // 
            chkProtector.AutoSize = true;
            chkProtector.Location = new Point(15, 87);
            chkProtector.Name = "chkProtector";
            chkProtector.Size = new Size(92, 24);
            chkProtector.TabIndex = 2;
            chkProtector.Text = "Protector";
            chkProtector.UseVisualStyleBackColor = true;
            // 
            // chkCarcasa
            // 
            chkCarcasa.AutoSize = true;
            chkCarcasa.Location = new Point(15, 57);
            chkCarcasa.Name = "chkCarcasa";
            chkCarcasa.Size = new Size(82, 24);
            chkCarcasa.TabIndex = 1;
            chkCarcasa.Text = "Carcasa";
            chkCarcasa.UseVisualStyleBackColor = true;
            // 
            // chkNfc
            // 
            chkNfc.AutoSize = true;
            chkNfc.Location = new Point(15, 27);
            chkNfc.Name = "chkNfc";
            chkNfc.Size = new Size(58, 24);
            chkNfc.TabIndex = 0;
            chkNfc.Text = "NFC";
            chkNfc.UseVisualStyleBackColor = true;
            // 
            // listaMoviles
            // 
            listaMoviles.FormattingEnabled = true;
            listaMoviles.Location = new Point(416, 85);
            listaMoviles.Name = "listaMoviles";
            listaMoviles.Size = new Size(328, 184);
            listaMoviles.TabIndex = 11;
            listaMoviles.SelectedIndexChanged += new System.EventHandler(this.lstLibros_SelectedIndexChanged);
            // 
            // panel1
            // 
            panel1.Controls.Add(btnSalir);
            panel1.Controls.Add(btnNuevo);
            panel1.Controls.Add(btnModificar);
            panel1.Controls.Add(btnBaja);
            panel1.Controls.Add(btnAlta);
            panel1.Location = new Point(416, 288);
            panel1.Name = "panel1";
            panel1.Size = new Size(328, 123);
            panel1.TabIndex = 12;
            // 
            // btnSalir
            // 
            btnSalir.Location = new Point(161, 59);
            btnSalir.Name = "btnSalir";
            btnSalir.Size = new Size(101, 44);
            btnSalir.TabIndex = 4;
            btnSalir.Text = "Salir";
            btnSalir.UseVisualStyleBackColor = true;
            btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // btnNuevo
            // 
            btnNuevo.Location = new Point(54, 59);
            btnNuevo.Name = "btnNuevo";
            btnNuevo.Size = new Size(101, 44);
            btnNuevo.TabIndex = 3;
            btnNuevo.Text = "Nuevo";
            btnNuevo.UseVisualStyleBackColor = true;
            btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnModificar
            // 
            btnModificar.Location = new Point(217, 3);
            btnModificar.Name = "btnModificar";
            btnModificar.Size = new Size(101, 44);
            btnModificar.TabIndex = 2;
            btnModificar.Text = "Modificar";
            btnModificar.UseVisualStyleBackColor = true;
            btnModificar.Click += new System.EventHandler(this.btnModificar_Click);
            // 
            // btnBaja
            // 
            btnBaja.Location = new Point(110, 3);
            btnBaja.Name = "btnBaja";
            btnBaja.Size = new Size(101, 44);
            btnBaja.TabIndex = 1;
            btnBaja.Text = "Baja";
            btnBaja.UseVisualStyleBackColor = true;
            btnBaja.Click += new System.EventHandler(this.btnBaja_Click);
            // 
            // btnAlta
            // 
            btnAlta.Location = new Point(3, 3);
            btnAlta.Name = "btnAlta";
            btnAlta.Size = new Size(101, 44);
            btnAlta.TabIndex = 0;
            btnAlta.Text = "Alta";
            btnAlta.UseVisualStyleBackColor = true;
            btnAlta.Click += new System.EventHandler(this.btnAlta_Click);
            // 
            // cbxMarcas
            // 
            cbxMarcas.Font = new Font("Segoe UI", 13F);
            cbxMarcas.FormattingEnabled = true;
            cbxMarcas.Items.AddRange(new object[] { "Apple", "Samsung", "Xiaomi", "PeraPhone", "Hawei", "Google", "Nothing", "Oppo", "Sony", "Vivo" });
            cbxMarcas.Location = new Point(181, 142);
            cbxMarcas.Name = "cbxMarcas";
            cbxMarcas.Size = new Size(188, 38);
            cbxMarcas.TabIndex = 13;
            cbxMarcas.Text = "Seleccionar";
            // 
            // Principal
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(781, 478);
            Controls.Add(cbxMarcas);
            Controls.Add(panel1);
            Controls.Add(listaMoviles);
            Controls.Add(Extra);
            Controls.Add(Almacenamiento);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtPrecio);
            Controls.Add(txtModelo);
            Controls.Add(textBox1);
            Name = "Principal";
            Text = "OhMyMobile";
            Load += Form1_Load;
            Almacenamiento.ResumeLayout(false);
            Almacenamiento.PerformLayout();
            Extra.ResumeLayout(false);
            Extra.PerformLayout();
            panel1.ResumeLayout(false);
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBox1;
        private TextBox txtModelo;
        private TextBox txtPrecio;
        private Label label1;
        private Label label2;
        private Label label3;
        private GroupBox Almacenamiento;
        private RadioButton rb128;
        private RadioButton rb256;
        private GroupBox Extra;
        private CheckBox chkNfc;
        private CheckBox chkProtector;
        private CheckBox chkCarcasa;
        private ListBox listaMoviles;
        private Panel panel1;
        private Button btnAlta;
        private Button btnSalir;
        private Button btnNuevo;
        private Button btnModificar;
        private Button btnBaja;
        private ComboBox cbxMarcas;
    }
}
