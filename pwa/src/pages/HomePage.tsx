import '../styles/pages.css'

interface HomePageProps {
  onNavigate: (page: string) => void
}

export default function HomePage({ onNavigate }: HomePageProps) {
  const features = [
    { emoji: '🎹', title: 'Play Piano', desc: 'Interactive 25-key keyboard', action: () => onNavigate('piano') },
    { emoji: '📚', title: 'Lessons', desc: '5 levels from beginner to master', action: () => onNavigate('lessons') },
    { emoji: '🎮', title: 'Games', desc: 'Fun mini games to practice', action: () => onNavigate('games') },
    { emoji: '⏱️', title: 'Metronome', desc: 'BPM control for practice', action: () => onNavigate('metronome') },
  ]

  return (
    <div className="home-page">
      <div className="hero">
        <h1 className="title">🎹 PianoKu</h1>
        <p className="subtitle">Learn Piano Interactively</p>
      </div>

      <div className="features-grid">
        {features.map((feature, idx) => (
          <div key={idx} className="feature-card" onClick={feature.action}>
            <div className="feature-emoji">{feature.emoji}</div>
            <h3>{feature.title}</h3>
            <p>{feature.desc}</p>
          </div>
        ))}
      </div>

      <div className="info-section">
        <h2>Welcome to PianoKu! 🎵</h2>
        <p>Learn piano at your own pace with interactive lessons, fun games, and practice tools.</p>
        <p>Start by exploring the navigation menu above!</p>
      </div>
    </div>
  )
}
