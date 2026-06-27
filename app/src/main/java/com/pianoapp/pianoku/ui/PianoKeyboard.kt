package com.pianoapp.pianoku.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pianoapp.pianoku.AudioSynthesizer

@Composable
fun PianoKeyboard(
    synthesizer: AudioSynthesizer,
    onNotePlay: (String) -> Unit = {}
) {
    val whiteNotes = listOf("C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5")
    val blackNotes = listOf("C#4", "D#4", "F#4", "G#4", "A#4")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Piano Keyboard",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // White keys
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(whiteNotes) { note ->
                PianoKey(
                    note = note,
                    isBlackKey = false,
                    onPress = {
                        synthesizer.playNote(note)
                        onNotePlay(note)
                    }
                )
            }
        }

        // Black keys overlay (simplified)
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = -30.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(blackNotes) { note ->
                Box(modifier = Modifier.width(25.dp))
                PianoKey(
                    note = note,
                    isBlackKey = true,
                    onPress = {
                        synthesizer.playNote(note)
                        onNotePlay(note)
                    }
                )
            }
        }
    }
}

@Composable
fun PianoKey(
    note: String,
    isBlackKey: Boolean,
    onPress: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(if (isBlackKey) 30.dp else 40.dp)
            .height(if (isBlackKey) 80.dp else 120.dp)
            .background(
                color = if (isBlackKey) Color(0xFF2C2C2C) else Color(0xFFFAFAFA),
                shape = RoundedCornerShape(4.dp)
            )
            .border(
                width = 1.dp,
                color = if (isBlackKey) Color.Black else Color.Gray,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { onPress() }
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = note,
            color = if (isBlackKey) Color.White else Color.Black,
            fontSize = 10.sp
        )
    }
}
