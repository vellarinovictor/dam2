package com.victorvellarino.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.victorvellarino.composetext.ui.theme.ComposeTextTheme
import kotlin.collections.List as List1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyApp(modifier: Modifier) {
    var destino by remember { mutableStateOf(0) }
    var names = remember { mutableStateListOf("Juan", "Joze", "Pepelu", "Diego") }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        FlowRow(horizontalArrangement = Arrangement.SpaceEvenly) {
            BotonGenerico("Contador", onChange = { destino = 1 })
            BotonGenerico("Imagen", onChange = { destino = 2 })
            BotonGenerico("ImagenBoxed", onChange = { destino = 3 })
            BotonGenerico("Una lista", onChange = { destino = 4 })
        }
//        Spacer(Modifier.padding(48.dp))
        when (destino) {
            1 -> TextoContador()
            2 -> ImagenPerro()
            3 -> ImagenPerroBoxed()
            4 -> ListaNombres(names)
            else -> TextoBienvenido()
        }
    }
}

@Composable
fun ListaNombres(names: MutableList<String>) {
    Column {
        for (item in names) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            )
            { Text(item) }

        }
    }
}


@Composable
fun BotonGenerico(caption: String, onChange: () -> Unit) {
    Button(onClick = onChange) { Text(caption) }
}


@Composable
fun ImagenPerroBoxed() {
    Box {
        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = "Una imagen",
            Modifier.size(256.dp),
        )
        Text(
            "PerroSanxe",
            fontSize = 24.sp, modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(4.dp, 6.dp),
            color = Color.White
        )
    }
}

@Composable
fun TextoContador() {
    var total by remember { mutableStateOf(0) }
    ContadorCompuesto(total, onDecrement = { total-- }, onIncrement = { total++ })
}

@Composable
fun ContadorCompuesto(total: Int, onDecrement: () -> Unit, onIncrement: () -> Unit) {
    Text(
        total.toString(),
        fontSize = 48.sp
    )
    OutlinedButton(onClick = onDecrement) { Text("-") }
    OutlinedButton(onClick = onIncrement) { Text("+") }


}

@Composable
fun ImagenPerro() {
    Column {
        Image(
            painter = painterResource(R.drawable.images),
            contentDescription = "Una imagen"
        )
        Text("PerroSanxe", fontSize = 24.sp)
    }

}

@Composable
fun TextoBienvenido() {
    Text("Bienvenidos")
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    ComposeTextTheme {
        MyApp(modifier = Modifier)
    }
}