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
            textBox7 = new TextBox();
            textBox9 = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            groupBox1 = new GroupBox();
            radioButton2 = new RadioButton();
            radioButton1 = new RadioButton();
            groupBox2 = new GroupBox();
            checkBox3 = new CheckBox();
            checkBox1 = new CheckBox();
            checkBox2 = new CheckBox();
            listaMoviles = new ListBox();
            panel1 = new Panel();
            btnSalir = new Button();
            btnNuevo = new Button();
            btnModificar = new Button();
            btnBaja = new Button();
            btnAlta = new Button();
            comboBox1 = new ComboBox();
            groupBox1.SuspendLayout();
            groupBox2.SuspendLayout();
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
            // textBox7
            // 
            textBox7.Font = new Font("Segoe UI", 13F);
            textBox7.Location = new Point(181, 85);
            textBox7.Multiline = true;
            textBox7.Name = "textBox7";
            textBox7.Size = new Size(188, 43);
            textBox7.TabIndex = 1;
            // 
            // textBox9
            // 
            textBox9.Font = new Font("Segoe UI", 13F);
            textBox9.Location = new Point(181, 191);
            textBox9.Multiline = true;
            textBox9.Name = "textBox9";
            textBox9.Size = new Size(188, 41);
            textBox9.TabIndex = 3;
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
            // groupBox1
            // 
            groupBox1.Controls.Add(radioButton2);
            groupBox1.Controls.Add(radioButton1);
            groupBox1.Location = new Point(17, 261);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(142, 150);
            groupBox1.TabIndex = 9;
            groupBox1.TabStop = false;
            groupBox1.Text = "Almacenamiento";
            // 
            // radioButton2
            // 
            radioButton2.AutoSize = true;
            radioButton2.Location = new Point(23, 56);
            radioButton2.Name = "radioButton2";
            radioButton2.Size = new Size(73, 24);
            radioButton2.TabIndex = 1;
            radioButton2.TabStop = true;
            radioButton2.Text = "256GB";
            radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton1
            // 
            radioButton1.AutoSize = true;
            radioButton1.Location = new Point(23, 26);
            radioButton1.Name = "radioButton1";
            radioButton1.Size = new Size(73, 24);
            radioButton1.TabIndex = 0;
            radioButton1.TabStop = true;
            radioButton1.Text = "128GB";
            radioButton1.UseVisualStyleBackColor = true;
            // 
            // groupBox2
            // 
            groupBox2.Controls.Add(checkBox3);
            groupBox2.Controls.Add(checkBox1);
            groupBox2.Controls.Add(checkBox2);
            groupBox2.Location = new Point(227, 261);
            groupBox2.Name = "groupBox2";
            groupBox2.Size = new Size(142, 150);
            groupBox2.TabIndex = 10;
            groupBox2.TabStop = false;
            groupBox2.Text = "Extras";
            // 
            // checkBox3
            // 
            checkBox3.AutoSize = true;
            checkBox3.Location = new Point(15, 87);
            checkBox3.Name = "checkBox3";
            checkBox3.Size = new Size(92, 24);
            checkBox3.TabIndex = 2;
            checkBox3.Text = "Protector";
            checkBox3.UseVisualStyleBackColor = true;
            // 
            // checkBox1
            // 
            checkBox1.AutoSize = true;
            checkBox1.Location = new Point(15, 57);
            checkBox1.Name = "checkBox1";
            checkBox1.Size = new Size(82, 24);
            checkBox1.TabIndex = 1;
            checkBox1.Text = "Carcasa";
            checkBox1.UseVisualStyleBackColor = true;
            // 
            // checkBox2
            // 
            checkBox2.AutoSize = true;
            checkBox2.Location = new Point(15, 27);
            checkBox2.Name = "checkBox2";
            checkBox2.Size = new Size(58, 24);
            checkBox2.TabIndex = 0;
            checkBox2.Text = "NFC";
            checkBox2.UseVisualStyleBackColor = true;
            // 
            // listaMoviles
            // 
            listaMoviles.FormattingEnabled = true;
            listaMoviles.Location = new Point(416, 85);
            listaMoviles.Name = "listaMoviles";
            listaMoviles.Size = new Size(328, 184);
            listaMoviles.TabIndex = 11;
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
            // 
            // btnNuevo
            // 
            btnNuevo.Location = new Point(54, 59);
            btnNuevo.Name = "btnNuevo";
            btnNuevo.Size = new Size(101, 44);
            btnNuevo.TabIndex = 3;
            btnNuevo.Text = "Nuevo";
            btnNuevo.UseVisualStyleBackColor = true;
            // 
            // btnModificar
            // 
            btnModificar.Location = new Point(217, 3);
            btnModificar.Name = "btnModificar";
            btnModificar.Size = new Size(101, 44);
            btnModificar.TabIndex = 2;
            btnModificar.Text = "Modificar";
            btnModificar.UseVisualStyleBackColor = true;
            // 
            // btnBaja
            // 
            btnBaja.Location = new Point(110, 3);
            btnBaja.Name = "btnBaja";
            btnBaja.Size = new Size(101, 44);
            btnBaja.TabIndex = 1;
            btnBaja.Text = "Baja";
            btnBaja.UseVisualStyleBackColor = true;
            // 
            // btnAlta
            // 
            btnAlta.Location = new Point(3, 3);
            btnAlta.Name = "btnAlta";
            btnAlta.Size = new Size(101, 44);
            btnAlta.TabIndex = 0;
            btnAlta.Text = "Alta";
            btnAlta.UseVisualStyleBackColor = true;
            // 
            // comboBox1
            // 
            comboBox1.Font = new Font("Segoe UI", 13F);
            comboBox1.FormattingEnabled = true;
            comboBox1.Items.AddRange(new object[] { "Apple", "Samsung", "Xiaomi", "PeraPhone", "Hawei", "Google", "Nothing", "Oppo", "Sony", "Vivo" });
            comboBox1.Location = new Point(181, 142);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(188, 38);
            comboBox1.TabIndex = 13;
            comboBox1.Text = "Seleccionar";
            // 
            // Principal
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(781, 478);
            Controls.Add(comboBox1);
            Controls.Add(panel1);
            Controls.Add(listaMoviles);
            Controls.Add(groupBox2);
            Controls.Add(groupBox1);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBox9);
            Controls.Add(textBox7);
            Controls.Add(textBox1);
            Name = "Principal";
            Text = "Form1";
            Load += Form1_Load;
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            groupBox2.ResumeLayout(false);
            groupBox2.PerformLayout();
            panel1.ResumeLayout(false);
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox textBox1;
        private TextBox textBox7;
        private TextBox textBox9;
        private Label label1;
        private Label label2;
        private Label label3;
        private GroupBox groupBox1;
        private RadioButton radioButton1;
        private RadioButton radioButton2;
        private GroupBox groupBox2;
        private CheckBox checkBox2;
        private CheckBox checkBox3;
        private CheckBox checkBox1;
        private ListBox listaMoviles;
        private Panel panel1;
        private Button btnAlta;
        private Button btnSalir;
        private Button btnNuevo;
        private Button btnModificar;
        private Button btnBaja;
        private ComboBox comboBox1;
    }
}
