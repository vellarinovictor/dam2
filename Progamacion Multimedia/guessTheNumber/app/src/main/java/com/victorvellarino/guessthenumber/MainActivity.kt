package com.victorvellarino.guessthenumber

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.victorvellarino.guessthenumber.data.SecretNumber
import com.victorvellarino.guessthenumber.ui.theme.GuessTheNumberTheme

class MainActivity : ComponentActivity() {
    private val TAG: String = "JUEGO"

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessTheNumberTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MyApp(mySecretNumber = SecretNumber(), context = applicationContext)
                }
            }
        }
    }
}

@Composable
fun MyApp(mySecretNumber: SecretNumber, context: Context) {
    var userNumber by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = userNumber,
            onValueChange = { userNumber = it },
            label = { Text("Ingresa un numero del 1 al 10") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions (
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions ( onDone = {keyboardController?.hide()})

        )
        CheckButton(mySecretNumber, userNumber, context)
    }
}

@Composable
private fun CheckButton(mySecretNumber: SecretNumber, userNumber: String, context: Context) {
    var acertado: MutableState<Boolean> = remember { mutableStateOf(false) }
    Button(
        onClick = { comprobar(mySecretNumber, userNumber, context, acertado) },
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "")
        Text(if (acertado.value) "Volver a jugar" else "Enviar")
    }

}

fun comprobar(
    mySecretNumber: SecretNumber,
    userNumber: String,
    context: Context,
    acertado: MutableState<Boolean>
) {
    try {
        if (mySecretNumber.secretNumber == userNumber.toInt()) {
            Log.i(
                "JOGO",
                "Acertaste crack. El numero era " + mySecretNumber.secretNumber + ". Ahora el numero se va a cambiar"
            )
            Toast.makeText(context, "Has acertado", Toast.LENGTH_LONG).show()
            acertado.value = true
            mySecretNumber.changeNumber()
        } else {
            Log.i("JOGO", "Ese no es, Te quedan 2 intentos o explota el ordenador")
            Toast.makeText(context, "Has fallado, imbecil", Toast.LENGTH_LONG).show()

        }
    } catch (exception: NumberFormatException) {
        Toast.makeText(context, "Eso no es un número", Toast.LENGTH_SHORT).show()
    }

}