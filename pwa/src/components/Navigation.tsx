import './Navigation.css'

interface NavigationProps {
  currentPage: string
  onNavigate: (page: any) => void
}

export default function Navigation({ currentPage, onNavigate }: NavigationProps) {
  return (
    <nav className="navigation">
      <button
        className={`nav-item ${currentPage === 'home' ? 'active' : ''}`}
        onClick={() => onNavigate('home')}
      >
        🏠 Home
      </button>
      <button
        className={`nav-item ${currentPage === 'piano' ? 'active' : ''}`}
        onClick={() => onNavigate('piano')}
      >
        🎹 Piano
      </button>
      <button
        className={`nav-item ${currentPage === 'lessons' ? 'active' : ''}`}
        onClick={() => onNavigate('lessons')}
      >
        📚 Lessons
      </button>
      <button
        className={`nav-item ${currentPage === 'games' ? 'active' : ''}`}
        onClick={() => onNavigate('games')}
      >
        🎮 Games
      </button>
      <button
        className={`nav-item ${currentPage === 'metronome' ? 'active' : ''}`}
        onClick={() => onNavigate('metronome')}
      >
        ⏱️ Metronome
      </button>
    </nav>
  )
}
