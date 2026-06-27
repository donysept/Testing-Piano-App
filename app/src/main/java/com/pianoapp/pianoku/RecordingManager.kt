package com.pianoapp.pianoku

import java.io.File

data class Recording(
    val id: String,
    val name: String,
    val filePath: String,
    val duration: Long,
    val dateCreated: Long
)

class RecordingManager {
    private val recordings = mutableListOf<Recording>()

    fun addRecording(recording: Recording) {
        recordings.add(recording)
    }

    fun getRecordings(): List<Recording> = recordings.toList()

    fun deleteRecording(id: String) {
        recordings.removeAll { it.id == id }
    }

    fun getRecordingById(id: String): Recording? {
        return recordings.find { it.id == id }
    }
}
