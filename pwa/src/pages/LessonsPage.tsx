import '../styles/pages.css'

const LESSONS = [
  { id: 1, title: 'Getting Started', level: 1, desc: 'Learn the basics of piano' },
  { id: 2, title: 'Notes & Keys', level: 2, desc: 'Understand notes and keyboard' },
  { id: 3, title: 'Scales', level: 3, desc: 'Master musical scales' },
  { id: 4, title: 'Chords', level: 4, desc: 'Play complex chords' },
  { id: 5, title: 'Improvisation', level: 5, desc: 'Create your own music' },
]

export default function LessonsPage() {
  return (
    <div className="lessons-page">
      <h2>📚 Piano Lessons</h2>
      <div className="lessons-grid">
        {LESSONS.map((lesson) => (
          <div key={lesson.id} className="lesson-card">
            <div className="level-badge">Level {lesson.level}</div>
            <h3>{lesson.title}</h3>
            <p>{lesson.desc}</p>
            <button className="btn-secondary">Start Lesson</button>
          </div>
        ))}
      </div>
    </div>
  )
}
