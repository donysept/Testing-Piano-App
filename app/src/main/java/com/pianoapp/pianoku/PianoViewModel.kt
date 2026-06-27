package com.pianoapp.pianoku

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PianoViewModel : ViewModel() {
    private val synthesizer = AudioSynthesizer()
    private val _playedNotes = MutableStateFlow<List<String>>(emptyList())
    val playedNotes: StateFlow<List<String>> = _playedNotes

    fun playNote(note: String) {
        synthesizer.playNote(note)
        val currentNotes = _playedNotes.value.toMutableList()
        currentNotes.add(note)
        _playedNotes.value = currentNotes
    }

    fun clearNotes() {
        _playedNotes.value = emptyList()
    }

    override fun onCleared() {
        super.onCleared()
        synthesizer.release()
    }
}
