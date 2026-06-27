package com.pianoapp.pianoku

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class RecordingViewModel : ViewModel() {
    private val recordingManager = RecordingManager()
    private val _recordings = MutableStateFlow<List<Recording>>(emptyList())
    val recordings: StateFlow<List<Recording>> = _recordings
    
    private val _isRecording = MutableStateFlow(false)
    val isRecording: StateFlow<Boolean> = _isRecording

    fun startRecording() {
        _isRecording.value = true
    }

    fun stopRecording(recordingName: String) {
        _isRecording.value = false
        val recording = Recording(
            id = UUID.randomUUID().toString(),
            name = recordingName,
            filePath = "/storage/recordings/$recordingName.wav",
            duration = 0L,
            dateCreated = System.currentTimeMillis()
        )
        recordingManager.addRecording(recording)
        _recordings.value = recordingManager.getRecordings()
    }

    fun deleteRecording(recordingId: String) {
        recordingManager.deleteRecording(recordingId)
        _recordings.value = recordingManager.getRecordings()
    }

    fun getRecordings() {
        _recordings.value = recordingManager.getRecordings()
    }
}
