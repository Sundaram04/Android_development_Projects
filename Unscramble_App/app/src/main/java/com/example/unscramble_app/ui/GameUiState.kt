package com.example.unscramble_app.ui

/*
data class that represents the game UI state
 */
data class GameUiState(
    val currentScrambleWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)