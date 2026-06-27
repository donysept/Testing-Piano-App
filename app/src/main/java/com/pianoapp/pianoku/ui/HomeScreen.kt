package com.pianoapp.pianoku.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onLessonClick: () -> Unit,
    onGameClick: () -> Unit,
    onPlayClick: () -> Unit,
    onRecordClick: () -> Unit,
    onMetronomeClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "🎹 PianoKu",
            fontSize = 36.sp,
            modifier = Modifier.padding(32.dp)
        )
        Text(
            text = "Learn Piano the Fun Way!",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        MenuButton(text = "Play Piano", onClick = onPlayClick)
        MenuButton(text = "Lessons", onClick = onLessonClick)
        MenuButton(text = "Games", onClick = onGameClick)
        MenuButton(text = "Record", onClick = onRecordClick)
        MenuButton(text = "Metronome", onClick = onMetronomeClick)
        MenuButton(text = "Settings", onClick = onSettingsClick)
    }
}

@Composable
fun MenuButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(8.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}
