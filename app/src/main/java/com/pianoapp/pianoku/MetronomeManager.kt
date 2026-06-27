package com.pianoapp.pianoku

import kotlin.math.abs

class MetronomeManager {
    private var bpm: Int = 120
    private var isRunning: Boolean = false
    private var onTickListener: (() -> Unit)? = null

    fun setBpm(newBpm: Int) {
        bpm = newBpm.coerceIn(40, 200)
    }

    fun getBpm(): Int = bpm

    fun start() {
        isRunning = true
        tick()
    }

    fun stop() {
        isRunning = false
    }

    fun isRunning(): Boolean = isRunning

    private fun tick() {
        if (!isRunning) return
        onTickListener?.invoke()
        val delayMs = (60000 / bpm).toLong()
        Thread.sleep(delayMs)
        tick()
    }

    fun setOnTickListener(listener: () -> Unit) {
        onTickListener = listener
    }
}
