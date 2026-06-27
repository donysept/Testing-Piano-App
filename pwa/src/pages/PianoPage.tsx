import { useState } from 'react'
import '../styles/pages.css'

const NOTES = ['C4', 'D4', 'E4', 'F4', 'G4', 'A4', 'B4', 'C5', 'D5', 'E5']
const WHITE_KEYS = ['C4', 'D4', 'E4', 'F4', 'G4', 'A4', 'B4', 'C5', 'D5', 'E5']
const BLACK_KEYS = ['C#4', 'D#4', 'F#4', 'G#4', 'A#4', 'C#5', 'D#5']

export default function PianoPage() {
  const [playedNotes, setPlayedNotes] = useState<string[]>([])
  const [activeKey, setActiveKey] = useState<string | null>(null)

  const playNote = (note: string) => {
    setActiveKey(note)
    setPlayedNotes([...playedNotes, note])
    setTimeout(() => setActiveKey(null), 200)

    // Play sound using Web Audio API
    const audioContext = new (window.AudioContext || (window as any).webkitAudioContext)()
    const noteFreq = getFrequency(note)
    const oscillator = audioContext.createOscillator()
    const gainNode = audioContext.createGain()

    oscillator.connect(gainNode)
    gainNode.connect(audioContext.destination)
    oscillator.frequency.value = noteFreq
    oscillator.type = 'sine'

    gainNode.gain.setValueAtTime(0.3, audioContext.currentTime)
    gainNode.gain.exponentialRampToValueAtTime(0.01, audioContext.currentTime + 0.5)

    oscillator.start(audioContext.currentTime)
    oscillator.stop(audioContext.currentTime + 0.5)
  }

  const getFrequency = (note: string): number => {
    const noteFreqs: { [key: string]: number } = {
      'C4': 261.63, 'C#4': 277.18, 'D4': 293.66, 'D#4': 311.13, 'E4': 329.63,
      'F4': 349.23, 'F#4': 369.99, 'G4': 392.00, 'G#4': 415.30, 'A4': 440.00,
      'A#4': 466.16, 'B4': 493.88, 'C5': 523.25, 'C#5': 554.37, 'D5': 587.33,
      'D#5': 622.25, 'E5': 659.25, 'F5': 698.46, 'F#5': 739.99, 'G5': 783.99,
    }
    return noteFreqs[note] || 440
  }

  const clearNotes = () => {
    setPlayedNotes([])
  }

  return (
    <div className="piano-page">
      <h2>🎹 Piano Keyboard</h2>
      <div className="piano-container">
        <div className="keyboard">
          {WHITE_KEYS.map((note) => (
            <button
              key={note}
              className={`key white ${activeKey === note ? 'active' : ''}`}
              onClick={() => playNote(note)}
            >
              {note}
            </button>
          ))}
        </div>
      </div>

      <div className="controls">
        <button className="btn-primary" onClick={clearNotes}>Clear Notes</button>
      </div>

      <div className="played-notes">
        <h3>Played Notes: {playedNotes.join(' → ')}</h3>
      </div>
    </div>
  )
}
