package com.pianoapp.pianoku.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pianoapp.pianoku.MetronomeManager

@Composable
fun MetronomeScreen(metronomeManager: MetronomeManager) {
    var bpm by remember { mutableStateOf(metronomeManager.getBpm().toFloat()) }
    var isRunning by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Metronome",
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BPM: ${bpm.toInt()}",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Slider(
                    value = bpm,
                    onValueChange = {
                        bpm = it
                        metronomeManager.setBpm(it.toInt())
                    },
                    valueRange = 40f..200f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }

        Button(
            onClick = {
                if (isRunning) {
                    metronomeManager.stop()
                } else {
                    metronomeManager.start()
                }
                isRunning = !isRunning
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = if (isRunning) "Stop" else "Start")
        }
    }
}
