package com.pianoapp.pianoku

data class Game(
    val id: String,
    val name: String,
    val description: String,
    val difficulty: Int
)

class GameManager {
    private val games = mutableListOf<Game>()

    init {
        initializeGames()
    }

    private fun initializeGames() {
        games.addAll(listOf(
            Game(
                id = "game_1",
                name = "Note Recognition",
                description = "Identify piano notes by ear",
                difficulty = 1
            ),
            Game(
                id = "game_2",
                name = "Piano Tiles",
                description = "Tap the falling piano keys in sequence",
                difficulty = 2
            ),
            Game(
                id = "game_3",
                name = "Melody Master",
                description = "Recreate melodies by playing the correct keys",
                difficulty = 3
            ),
            Game(
                id = "game_4",
                name = "Chord Challenge",
                description = "Play the correct chords based on symbols",
                difficulty = 4
            )
        ))
    }

    fun getAllGames(): List<Game> = games.toList()

    fun getGameById(id: String): Game? = games.find { it.id == id }

    fun getGamesByDifficulty(difficulty: Int): List<Game> =
        games.filter { it.difficulty <= difficulty }
}
