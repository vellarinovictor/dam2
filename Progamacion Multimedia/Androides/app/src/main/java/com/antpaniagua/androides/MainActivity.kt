package com.antpaniagua.androides

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antpaniagua.androides.ui.theme.AndroidesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

/**

 * Tareas a resolver
 *
 * 1. Refactoriza la aplicación para que desde MyApp se llame a una función llamada AndroideScreen que muestre la columna y el texto
 *
 * 2. En AndroideScreen genera un espacio con cuatro columas donde mostremos en cada una la imagen androideretro contenida en res, con un tamaño de 100.dp
 *
 * 3. Para distribuir el espacio en la fila prueba horizontalArrangement con los valores Arrangement.SpaceBetween o Arrangement.SpaceEvenly. Observa la diferencia
 *
 * 4. Inserta un espaciador (Spacer) de 24.dp
 *
 * 5. Inserta nuevamente la imagen del androide con un tamaño de 200.dp
 *
 * 6. A continuación inserta un Texto que ponga la palabra Rojo, seguido de un Switch apagado.
 * (Switch sólo requiere el valor checked booleano y el valor onCheckedChange  con la acción a realizar.
 *
 * 7. Repite lo mismo con otros dos switchs con la palabra azul y verde. Los tres valores comienzan en false.
 *
 * 8. Modifica la aplicación para que cada vez que se pulse un switch, el cambio sea visible en pantalla,
 * empleando para ello las expresiones lambda y la elevación de estado que hemos visto. Deberás, por tanto,
 * crear una pequeña función para el switch que mediante un callback devuelva el valor booleando del switch
 *
 * 9. Modifica la aplicación para que sólo se emplee una función de Switch, en el caso de que hayas realizado 3.
 * Asegúrate de que es una función sin estado (que actúa mediante elevación).
 *
 * 10. Modifica la aplicación para que cuando se seleccione un color, la imagen del Androide central se
 * reemplace por la del color seleccionado, empleando los patrones de estados y elevación.
 * Recuerda que los recursos de imágenes (como R.drawable.androideretro) son en realidad numeros enteros.
 *
 * FINAL: Añade todas las mejoras que consideres, tanto de apariencia como en el código.
 */
@Composable
fun MyApp(modifier: Modifier = Modifier) {
//    1. Refactoriza la aplicación para que desde MyApp se llame a una función llamada AndroideScreen que muestre la columna y el texto
    AndroideScreen();
}

@Composable
fun AndroideScreen() {
    var estado by remember { mutableStateOf(false) }
    var fotoRojo by remember { mutableStateOf(false) }
    var fotoVerde by remember { mutableStateOf(false) }
    var fotoAzul by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Androides de colores",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Row(
            //3. Para distribuir el espacio en la fila prueba horizontalArrangement con los valores Arrangement.SpaceBetween o Arrangement.SpaceEvenly. Observa la diferencia
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            //2. En AndroideScreen genera un espacio con cuatro columas donde mostremos en cada una la imagen androideretro contenida en res, con un tamaño de 100.dp
            Column {
                Image(
                    painter = painterResource(R.drawable.androidretro),
                    contentDescription = "Una imagen",
                    Modifier.size(100.dp)
                )
            }
            Column {
                Image(
                    painter = painterResource(R.drawable.androidretro),
                    contentDescription = "Una imagen",
                    Modifier.size(100.dp)
                )
            }
            Column {
                Image(
                    painter = painterResource(R.drawable.androidretro),
                    contentDescription = "Una imagen",
                    Modifier.size(100.dp)
                )
            }
            Column {
                Image(
                    painter = painterResource(R.drawable.androidretro),
                    contentDescription = "Una imagen",
                    Modifier.size(100.dp)
                )
            }

        }
        //4. Inserta un espaciador (Spacer) de 24.dp
        Spacer(modifier = Modifier.padding(24.dp))


        //5. Inserta nuevamente la imagen del androide con un tamaño de 200.dp
        if (fotoRojo) {
            Image(
                painter = painterResource(R.drawable.androidred),
                contentDescription = "Un androide",
                Modifier.size(200.dp),
            )
        } else if (fotoVerde) {
            Image(
                painter = painterResource(R.drawable.androidgreen),
                contentDescription = "Un androide",
                Modifier.size(200.dp),
            )
        } else if(fotoAzul) {
            Image(
            painter = painterResource(R.drawable.androidblue),
            contentDescription = "Un androide",
            Modifier.size(200.dp),
        )
        } else{
            Image(
                painter = painterResource(R.drawable.androidretro),
                contentDescription = "Un androide",
                Modifier.size(200.dp),
            )
        }
        //6. A continuación inserta un Texto que ponga la palabra Rojo, seguido de un Switch apagado.
        // (Switch sólo requiere el valor checked booleano y el valor onCheckedChange  con la acción a realizar.
        Text("Rojo")
        MiSwitch(estado, onCambio = {valor -> fotoRojo = valor; estado = !valor});
        Text("Verde")
        MiSwitch(estado, onCambio = {valor -> fotoRojo = valor; estado = !valor});
        Text("Verde")
        MiSwitch(estado, onCambio = {valor -> fotoRojo = valor; estado = !valor});


    }

}

@Composable
fun MiSwitch(state : Boolean, onCambio : (Boolean) -> Unit) {
    Switch(checked = state, onCheckedChange = onCambio)
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    AndroidesTheme {
        MyApp()
    }
}