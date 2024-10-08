package fr.kodesparkle.motus.presentation.gameboard.state

import fr.kodesparkle.motus.arch.Action


sealed interface GameBoardAction : Action {
    object SetLoading : GameBoardAction
    data class SetWord(val word: String) : GameBoardAction
    data class SetWin(val correctWord: String) : GameBoardAction
    data class SetIncorrectGuess(val currentWord: String) : GameBoardAction
    data class SetAllAttemptOver(val correctWord:String): GameBoardAction
    object SetNonExistentWord: GameBoardAction
}