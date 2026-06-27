package com.pianoapp.pianoku

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LessonViewModel : ViewModel() {
    private val lessonManager = LessonManager()
    private val _lessons = MutableStateFlow<List<Lesson>>(emptyList())
    val lessons: StateFlow<List<Lesson>> = _lessons
    
    private val _currentLesson = MutableStateFlow<Lesson?>(null)
    val currentLesson: StateFlow<Lesson?> = _currentLesson

    init {
        loadLessons()
    }

    private fun loadLessons() {
        _lessons.value = lessonManager.getAllLessons()
    }

    fun selectLesson(lessonId: String) {
        _currentLesson.value = lessonManager.getLessonById(lessonId)
    }

    fun getLessonsByDifficulty(difficulty: Int) {
        _lessons.value = lessonManager.getLessonsByDifficulty(difficulty)
    }
}
