package com.pianoapp.pianoku

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlin.math.sin
import kotlin.math.PI

class AudioSynthesizer {
    private var audioTrack: AudioTrack? = null
    private val sampleRate = 44100
    private val duration = 0.5f // 0.5 seconds per note
    
    private val pianoFrequencies = mapOf(
        "C4" to 261.63f,
        "C#4" to 277.18f,
        "D4" to 293.66f,
        "D#4" to 311.13f,
        "E4" to 329.63f,
        "F4" to 349.23f,
        "F#4" to 369.99f,
        "G4" to 392.00f,
        "G#4" to 415.30f,
        "A4" to 440.00f,
        "A#4" to 466.16f,
        "B4" to 493.88f,
        "C5" to 523.25f,
        "C#5" to 554.37f,
        "D5" to 587.33f,
        "D#5" to 622.25f,
        "E5" to 659.25f,
        "F5" to 698.46f,
        "F#5" to 739.99f,
        "G5" to 783.99f,
        "G#5" to 830.61f,
        "A5" to 880.00f,
        "A#5" to 932.33f,
        "B5" to 987.77f
    )

    init {
        initializeAudioTrack()
    }

    private fun initializeAudioTrack() {
        val bufferSize = AudioTrack.getMinBufferSize(
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        
        audioTrack = AudioTrack(
            AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build(),
            AudioFormat.Builder()
                .setSampleRate(sampleRate)
                .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                .build(),
            bufferSize,
            AudioTrack.MODE_STREAM,
            AudioAttributes.USAGE_MEDIA
        )
    }

    fun playNote(noteName: String, durationMs: Long = 500) {
        val frequency = pianoFrequencies[noteName] ?: return
        playTone(frequency, durationMs)
    }

    private fun playTone(frequency: Float, durationMs: Long) {
        val numSamples = (sampleRate * durationMs / 1000).toInt()
        val sample = ShortArray(numSamples)
        
        for (i in 0 until numSamples) {
            val angle = 2.0 * PI * frequency * i / sampleRate
            sample[i] = (Short.MAX_VALUE * sin(angle) * 0.5).toInt().toShort()
        }
        
        audioTrack?.play()
        audioTrack?.write(sample, 0, sample.size)
    }

    fun stop() {
        audioTrack?.stop()
    }

    fun release() {
        audioTrack?.release()
        audioTrack = null
    }
}
