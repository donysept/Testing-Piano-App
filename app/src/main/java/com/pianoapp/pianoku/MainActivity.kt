package com.pianoapp.pianoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pianoapp.pianoku.ui.GameListScreen
import com.pianoapp.pianoku.ui.HomeScreen
import com.pianoapp.pianoku.ui.LessonListScreen
import com.pianoapp.pianoku.ui.MetronomeScreen
import com.pianoapp.pianoku.ui.PianoKeyboard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PianoKuApp()
                }
            }
        }
    }
}

@Composable
fun PianoKuApp() {
    val navController = rememberNavController()
    val pianoViewModel: PianoViewModel = viewModel()
    val lessonViewModel: LessonViewModel = viewModel()
    val gameViewModel: GameViewModel = viewModel()
    val recordingViewModel: RecordingViewModel = viewModel()
    val metronomeManager = MetronomeManager()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onPlayClick = { navController.navigate("play") },
                onLessonClick = { navController.navigate("lessons") },
                onGameClick = { navController.navigate("games") },
                onRecordClick = { navController.navigate("record") },
                onMetronomeClick = { navController.navigate("metronome") },
                onSettingsClick = { navController.navigate("settings") }
            )
        }
        composable("play") {
            PianoKeyboard(
                synthesizer = AudioSynthesizer(),
                onNotePlay = { pianoViewModel.playNote(it) }
            )
        }
        composable("lessons") {
            LessonListScreen(
                lessons = lessonViewModel.lessons.value,
                onLessonClick = { lessonViewModel.selectLesson(it.id) }
            )
        }
        composable("games") {
            GameListScreen(
                games = gameViewModel.games.value,
                onGameClick = { gameViewModel.selectGame(it.id) }
            )
        }
        composable("record") {
            // Recording screen placeholder
        }
        composable("metronome") {
            MetronomeScreen(metronomeManager = metronomeManager)
        }
        composable("settings") {
            // Settings screen placeholder
        }
    }
}
