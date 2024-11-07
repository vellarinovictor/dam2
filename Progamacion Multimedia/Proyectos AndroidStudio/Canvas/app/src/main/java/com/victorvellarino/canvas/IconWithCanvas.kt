package com.victorvellarino.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun IconWithCanvas(modifier: Modifier = Modifier) {
    var rotation by remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = Unit) {
        while (true) {
            rotation += 5f
            delay(30) // Adjust delay for rotation speed
        }
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "Android Icon",
            modifier = Modifier.size(64.dp)
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = Color.Red,
                topLeft = Offset(100f, 200f),
                size = size / 3f
            )

            rotate(rotation, pivot = center) {
                drawRect(
                    color = Color.Blue,
                    topLeft = Offset(center.x + 50f, center.y - 50f),
                    size = size / 4f
                )
            }
        }
    }
}