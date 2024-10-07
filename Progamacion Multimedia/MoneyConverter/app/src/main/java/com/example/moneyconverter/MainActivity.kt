package com.example.moneyconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moneyconverter.ui.theme.MoneyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneyConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Boton(caption: String, onChange: (Boolean) -> Unit) {
    Button(onClick = { onChange(caption == "€") }) { Text(caption) }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var cantidad by remember { mutableStateOf("") }
    val cambioAEuro = 0.91f
    val cambioADolar = 1.1f

    Column(
        modifier = Modifier
            .padding(
                20.dp
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text(text = "Ingresa una cantidad") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        //Text(text = cantidad.toString())
        Spacer(modifier.padding(0.dp, 10.dp))
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Boton("€", onChange = { esEuro: Boolean ->
                if (!esEuro) {
                    cantidad = (cantidad.toFloat() * cambioAEuro).toString()
                }
            })
            Boton("$", onChange = { esEuro: Boolean ->
                if (esEuro) {
                    cantidad = (cantidad.toFloat() * cambioADolar).toString()
                }
            })
        }
    }
}

/*@Composable
fun MyApp(modifier: Modifier = Modifier) {
var cantidad by remember { mutableStateOf("") } // Usamos String porque TextField maneja texto
val cambioAEuro = 0.91
val cambioADolar = 1.1

Column(modifier = modifier.padding(16.dp)) {
    TextField(
        value = cantidad,
        onValueChange = { cantidad = it }, // Captura el input del usuario
        label = { Text("Ingresa una cantidad") }, // Composable Text dentro de lambda
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number, // Configuramos el teclado numérico
            imeAction = ImeAction.Done
        )
    )

    Spacer(modifier = Modifier.height(10.dp))

    // Conversión y botones como antes
    Row {
        Boton("€", onChange = { esEuro: Boolean ->
            if (!esEuro && cantidad.isNotEmpty()) {
                cantidad = (cantidad.toFloat() * cambioAEuro).toString()
            }
        })

        Spacer(modifier = Modifier.width(10.dp))

        Boton("$", onChange = { esEuro: Boolean ->
            if (esEuro && cantidad.isNotEmpty()) {
                cantidad = (cantidad.toFloat() * cambioADolar).toString()
            }
        })
    }
}
}*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    MoneyConverterTheme {
        Greeting("Android")
    }
}
