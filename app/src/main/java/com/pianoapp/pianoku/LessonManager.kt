package com.pianoapp.pianoku

data class Lesson(
    val id: String,
    val title: String,
    val description: String,
    val notes: List<String>,
    val difficulty: Int, // 1-5
    val videoUrl: String = ""
)

class LessonManager {
    private val lessons = mutableListOf<Lesson>()

    init {
        initializeLessons()
    }

    private fun initializeLessons() {
        lessons.addAll(listOf(
            Lesson(
                id = "lesson_1",
                title = "Introduction to Piano",
                description = "Learn the basic keys and hand position",
                notes = listOf("C4", "D4", "E4", "F4", "G4"),
                difficulty = 1
            ),
            Lesson(
                id = "lesson_2",
                title = "C Major Scale",
                description = "Master the C major scale from C to C",
                notes = listOf("C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5"),
                difficulty = 1
            ),
            Lesson(
                id = "lesson_3",
                title = "Simple Melodies",
                description = "Play simple melodies using basic notes",
                notes = listOf("C4", "E4", "G4", "E4", "C4"),
                difficulty = 2
            ),
            Lesson(
                id = "lesson_4",
                title = "Chord Fundamentals",
                description = "Learn to play basic chords",
                notes = listOf("C4", "E4", "G4"),
                difficulty = 3
            ),
            Lesson(
                id = "lesson_5",
                title = "Advanced Melodies",
                description = "Play complex melodies with rhythm",
                notes = listOf("C5", "D5", "E5", "F5", "G5", "A5", "B5", "C5"),
                difficulty = 4
            )
        ))
    }

    fun getAllLessons(): List<Lesson> = lessons.toList()

    fun getLessonById(id: String): Lesson? = lessons.find { it.id == id }

    fun getLessonsByDifficulty(difficulty: Int): List<Lesson> =
        lessons.filter { it.difficulty <= difficulty }
}
