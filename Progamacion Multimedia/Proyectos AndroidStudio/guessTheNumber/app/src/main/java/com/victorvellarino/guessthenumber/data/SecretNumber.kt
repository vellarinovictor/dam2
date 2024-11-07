package com.victorvellarino.guessthenumber.data

class SecretNumber {
    val range = 1..10
    var secretNumber = range.random()

    fun changeNumber(){
        var newRandom = range.random()
        while (secretNumber == newRandom) {
            newRandom = range.random()
        }
        secretNumber = newRandom;
    }
}
