package ViewModel

import androidx.lifecycle.ViewModel
import data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _animal = MutableStateFlow("0")
    val animal: StateFlow<String> = _animal.asStateFlow()
    private val _animalSize = MutableStateFlow<Int>(0)
    val animalSize: StateFlow<Int> = _animalSize.asStateFlow()

    init {
        _animal.value = "Perro"
        _animalSize.value = 16
    }

    fun cambiarAnimal(){
        _animal.value = DataSource.animales.random()
    }

    fun aumentarAnimalSize(){
        _animalSize.value += 6
    }
}