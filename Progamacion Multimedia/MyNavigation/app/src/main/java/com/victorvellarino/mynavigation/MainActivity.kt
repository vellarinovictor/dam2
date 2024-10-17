package com.victorvellarino.mynavigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.victorvellarino.mynavigation.ui.theme.MyNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavSelected = { navController.navigate(it) })
        }
        composable("secondScreen") {
            SecondScreen(onNavController = { navController.navigate(it) })
        }
        composable("thirdScreen") {
            ThirdScreen(onGoBack = { navController.popBackStack() })
        }
    }
} //Fin Main

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onNavSelected: (String) -> Unit = {}) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.txt_welcome))
        Text("Bienvenido a la PANTALLA PRINCIPAL")
        Spacer(Modifier.size(16.dp))
        ElevatedButton(onClick = { onNavSelected("secondScreen") }) {
            Text("Navegar a la segunda pantalla")
        }
        OutlinedButton(onClick = { onNavSelected("thirdScreen") }) {
            Text("Navegar a la tercera pantalla")
        }
        ElevatedButton(onClick = { openBrowser(context, "https://developer.android.com/") }) {
            Text("Abrir el navegador")
        }
        ElevatedButton(onClick = { openMaps(context, "Badajoz") }) {
            Text("Mostrar Badajoz en el mapa")
        }
        ElevatedButton(onClick = {llamarTelefono(context, "555298442")}) {
            Text("Llamar a 666666666")
        }
        ElevatedButton(onClick = { lanzarSegundaActividad(context) }) {
            Text("Ir a la segunda actividad")
        }

    }
}//Fin HomeScreen

fun lanzarSegundaActividad(context: Context) {
    val intent = Intent(context, SegundaActividad::class.java)
    context.startActivity(intent)
}

fun llamarTelefono(context: Context, telefono: String) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
    context.startActivity(intent)
}

fun openBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

fun openMaps(context: Context, geo: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo: 0,0?q=$geo"))
    context.startActivity(intent)
}

@Composable
fun SecondScreen(onNavController: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Navegacion con Jetpack Compose")
        Text("Esto es la SEGUNDA pantalla")
        Spacer(Modifier.size(16.dp))
        OutlinedButton(onClick = { onNavController("thirdScreen") }) {
            Text("Navegar a la tercera pantalla")
        }
    }
}

@Composable
fun ThirdScreen(onGoBack: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Navegacion con Jetpack Compose")
        Text("Esto es la TERCERA pantalla")
        Spacer(Modifier.size(16.dp))
        OutlinedButton(onClick = { onGoBack() }) {
            Text("Volver a la anterior pantalla")
        }
    }
}