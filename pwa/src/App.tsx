import { useState, useEffect } from 'react'
import './App.css'
import Navigation from './components/Navigation'
import HomePage from './pages/HomePage'
import PianoPage from './pages/PianoPage'
import LessonsPage from './pages/LessonsPage'
import GamesPage from './pages/GamesPage'
import MetronomePage from './pages/MetronomePage'

type Page = 'home' | 'piano' | 'lessons' | 'games' | 'metronome'

function App() {
  const [currentPage, setCurrentPage] = useState<Page>('home')
  const [isOnline, setIsOnline] = useState(navigator.onLine)

  useEffect(() => {
    const handleOnline = () => setIsOnline(true)
    const handleOffline = () => setIsOnline(false)

    window.addEventListener('online', handleOnline)
    window.addEventListener('offline', handleOffline)

    return () => {
      window.removeEventListener('online', handleOnline)
      window.removeEventListener('offline', handleOffline)
    }
  }, [])

  const renderPage = () => {
    switch (currentPage) {
      case 'piano':
        return <PianoPage />
      case 'lessons':
        return <LessonsPage />
      case 'games':
        return <GamesPage />
      case 'metronome':
        return <MetronomePage />
      default:
        return <HomePage onNavigate={setCurrentPage} />
    }
  }

  return (
    <div className="app">
      {!isOnline && <div className="offline-banner">📡 Offline Mode</div>}
      <Navigation currentPage={currentPage} onNavigate={setCurrentPage} />
      <main className="main-content">
        {renderPage()}
      </main>
    </div>
  )
}

export default App
