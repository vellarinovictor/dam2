package com.victorvellarino.counter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorvellarino.counter.ui.theme.CounterTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }
    var aumentarTamanio by rememberSaveable { mutableStateOf(1) }
    var tamanio by rememberSaveable { mutableStateOf(128) }
    var miColor = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))


    Column(
        modifier
            .fillMaxSize()
            .padding()
            .background(miColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CounterWidget(
                tamanio,
                counter,
                onIncrease = {
                    counter++
                    if (aumentarTamanio == 3) {
                        if (tamanio<200){
                            tamanio++
                            aumentarTamanio = 0
                        }
                    } else aumentarTamanio++
                },
                onDecrease = { if (counter > 0) counter-- })
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        MyApp()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CounterWidget(tamanio: Int, counter: Int, onIncrease: () -> Unit, onDecrease: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "${counter}",
            modifier = Modifier
                .padding(16.dp)
                .combinedClickable(onClick = onIncrease, onLongClick = onDecrease),
            fontSize = tamanio.sp
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onIncrease,
                modifier = Modifier.padding(end = 16.dp)
            ) { Text(text = "+") }
            Button(
                onClick = onDecrease,
                modifier = Modifier.padding(start = 16.dp)
            ) { Text(text = "-") }
        }

    }
}

