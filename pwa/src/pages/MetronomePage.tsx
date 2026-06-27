import { useState } from 'react'
import '../styles/pages.css'

export default function MetronomePage() {
  const [bpm, setBpm] = useState(120)
  const [isRunning, setIsRunning] = useState(false)

  const toggleMetronome = () => {
    setIsRunning(!isRunning)
    if (!isRunning) {
      playClick()
    }
  }

  const playClick = () => {
    const audioContext = new (window.AudioContext || (window as any).webkitAudioContext)()
    const oscillator = audioContext.createOscillator()
    const gainNode = audioContext.createGain()

    oscillator.connect(gainNode)
    gainNode.connect(audioContext.destination)
    oscillator.frequency.value = 1000
    oscillator.type = 'sine'

    gainNode.gain.setValueAtTime(0.3, audioContext.currentTime)
    gainNode.gain.exponentialRampToValueAtTime(0.01, audioContext.currentTime + 0.1)

    oscillator.start(audioContext.currentTime)
    oscillator.stop(audioContext.currentTime + 0.1)
  }

  return (
    <div className="metronome-page">
      <h2>⏱️ Metronome</h2>
      <div className="metronome-container">
        <div className="bpm-display">{bpm} BPM</div>
        <input
          type="range"
          min="40"
          max="200"
          value={bpm}
          onChange={(e) => setBpm(Number(e.target.value))}
          className="bpm-slider"
        />
        <div className="bpm-labels">
          <span>40</span>
          <span>120</span>
          <span>200</span>
        </div>
        <button
          className={`btn-metronome ${isRunning ? 'running' : ''}`}
          onClick={toggleMetronome}
        >
          {isRunning ? '⏹️ Stop' : '▶️ Start'}
        </button>
      </div>
    </div>
  )
}
