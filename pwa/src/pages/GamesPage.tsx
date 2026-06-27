import '../styles/pages.css'

const GAMES = [
  { id: 1, title: 'Note Recognition', emoji: '🎵', desc: 'Identify notes by sound' },
  { id: 2, title: 'Piano Tiles', emoji: '⬇️', desc: 'Tap tiles in sequence' },
  { id: 3, title: 'Melody Master', emoji: '🎶', desc: 'Recreate melodies' },
  { id: 4, title: 'Chord Challenge', emoji: '🎸', desc: 'Play correct chords' },
]

export default function GamesPage() {
  return (
    <div className="games-page">
      <h2>🎮 Piano Games</h2>
      <div className="games-grid">
        {GAMES.map((game) => (
          <div key={game.id} className="game-card">
            <div className="game-emoji">{game.emoji}</div>
            <h3>{game.title}</h3>
            <p>{game.desc}</p>
            <button className="btn-secondary">Play Game</button>
          </div>
        ))}
      </div>
    </div>
  )
}
