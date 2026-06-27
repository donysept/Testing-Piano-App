package com.pianoapp.pianoku

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val gameManager = GameManager()
    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games
    
    private val _currentGame = MutableStateFlow<Game?>(null)
    val currentGame: StateFlow<Game?> = _currentGame

    init {
        loadGames()
    }

    private fun loadGames() {
        _games.value = gameManager.getAllGames()
    }

    fun selectGame(gameId: String) {
        _currentGame.value = gameManager.getGameById(gameId)
    }

    fun getGamesByDifficulty(difficulty: Int) {
        _games.value = gameManager.getGamesByDifficulty(difficulty)
    }
}
