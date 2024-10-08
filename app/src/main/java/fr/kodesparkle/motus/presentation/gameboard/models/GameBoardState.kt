package fr.kodesparkle.motus.presentation.gameboard.models

import fr.kodesparkle.motus.arch.State


sealed interface GameBoardState : State {
    object Loading: GameBoardState
    data class Word(val word: String): GameBoardState
    object Win: GameBoardState
    object Lose: GameBoardState
    object IncorrectWord: GameBoardState
    object None: GameBoardState


    data class Error(val message: String): GameBoardState
}
