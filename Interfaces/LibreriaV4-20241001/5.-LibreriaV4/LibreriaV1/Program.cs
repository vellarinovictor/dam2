﻿using LibreriaV2;
using System;
using System.Windows.Forms;

namespace LibreriaV1
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new PantallaPrincipal());
        }
    }
}
