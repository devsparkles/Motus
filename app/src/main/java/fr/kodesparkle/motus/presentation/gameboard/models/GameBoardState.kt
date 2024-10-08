package fr.kodesparkle.motus.presentation.gameboard.models

import fr.kodesparkle.motus.arch.State
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardAction


sealed interface GameBoardState : State {
    object Loading: GameBoardState
    data class Playing(val currentWord: String): GameBoardState
    data class Win(val correctWord: String): GameBoardState
    data class Lose(val correctWord: String): GameBoardState
    data class IncorrectGuess(val currentWord: String): GameBoardState
    object None: GameBoardState
    data class Error(val message: String): GameBoardState
    object NonExistentWord: GameBoardState

}


