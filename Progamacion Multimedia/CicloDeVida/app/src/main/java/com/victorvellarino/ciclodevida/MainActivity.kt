package com.victorvellarino.ciclodevida

import ViewModel.MainViewModel
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.victorvellarino.ciclodevida.ui.theme.CicloDeVidaTheme
import data.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CicloDeVidaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(modifier = Modifier.padding(innerPadding), viewModel = MainViewModel())
                }
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier, viewModel: MainViewModel = MainViewModel()) {
    val animal by viewModel.animal.collectAsState()
    val animalSize by viewModel.animalSize.collectAsState()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = animal.toString(),
            fontSize = animalSize.sp,
            modifier = Modifier.clickable {
                viewModel.cambiarAnimal()
                viewModel.aumentarAnimalSize()
            })
        Text(text = "Caballo")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CicloDeVidaTheme {
        Greeting("Android")
    }
}