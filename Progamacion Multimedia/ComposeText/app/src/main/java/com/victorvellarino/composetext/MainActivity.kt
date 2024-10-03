package com.victorvellarino.composetext

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorvellarino.composetext.ui.theme.ComposeTextTheme
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var names = mutableStateListOf("Juan", "Joze", "Pepelu", "Diego")

        for (i in (1..50)) names.add(names[i])
        enableEdgeToEdge()
        setContent {
            ComposeTextTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding), names)
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyApp(modifier: Modifier, names: MutableList<String>) {
    var destino by remember { mutableStateOf(0) }
    val listaBotones = listOf("Contador","Imagen","ImagenBoxed","Una lista","Una lista lazy","Un slider")


    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        FlowRow(horizontalArrangement = Arrangement.SpaceEvenly) {
            for (item in listaBotones) BotonGenerico(item, onChange = {destino = listaBotones.indexOf(item)+1})
//            BotonGenerico("Contador", onChange = { destino = 1 })
//            BotonGenerico("Imagen", onChange = { destino = 2 })
//            BotonGenerico("ImagenBoxed", onChange = { destino = 3 })
//            BotonGenerico("Una lista", onChange = { destino = 4 })
//            BotonGenerico("Una lista lazy", onChange = { destino = 5 })
//            BotonGenerico("Un slider", onChange = { destino = 6 })
        }
        Spacer(Modifier.padding(48.dp))
        when (destino) {
            1 -> TextoContador()
            2 -> ImagenPerro()
            3 -> ImagenPerroBoxed()
            4 -> ListaNombres(names)
            5 -> ListaLazyNombres(names)
            6 -> SliderTest()
            else -> TextoBienvenido()
        }
    }
}


@Composable
fun SliderTest() {
    var sliderState by remember { mutableStateOf<Float>(value = 20f) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)) {
        Text("Arrastra el slider")
        Spacer(Modifier.height(96.dp))
        Text(sliderState.toString(), fontSize = sliderState.sp)
        MiSlider(sliderState, onPositionChange = { position: Float -> sliderState = position })

    }
}

@Composable
fun MiSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        valueRange = 20f..40f,
        value = sliderPosition,
        onValueChange = { onPositionChange(it) })
}

@Composable
fun ListaNombres(names: MutableList<String>) {
    Column {
        for (item in names) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            )
            { CardItem(item) }

        }
    }
}

@Composable
fun ListaLazyNombres(names: MutableList<String>) {
    LazyColumn {
        items(items = names) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            )
            { CardItem(item) }
        }
    }
}

@Composable
fun CardItem(item: String) {
    Row() {
        Icon(
//            imageVector = icono(),
            imageVector = if ((0 until 5).random() != 4) Icons.Rounded.Person else Icons.Rounded.Face,
            contentDescription = "Icono",
            modifier = Modifier
                .size(64.dp)
                .clickable { Log.d("Tarjeton", "Has pinchado") },
            tint = Color((0..255).random(), (0..256).random(), (0..256).random())
        )
        Text(
            text = item,
            modifier = Modifier
                .padding(6.dp, 12.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

fun icono(): ImageVector {
    val random = (Math.random() * 5).toInt()
    if (random == 2) return Icons.Rounded.Face
    else return Icons.Rounded.Person
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
            color = Color.Red
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


//@Preview(showBackground = true)
//@Composable
//fun MyAppPreview() {
//    ComposeTextTheme {
//        MyApp(modifier = Modifier, names = names)
//    }
//}
