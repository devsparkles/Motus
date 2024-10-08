package fr.kodesparkle.motus.presentation.gameboard.state

import fr.kodesparkle.motus.arch.Action


sealed interface GameBoardAction : Action {
    object SetLoading: GameBoardAction
    data class SetWord(val word: String): GameBoardAction
    object SetWin: GameBoardAction
    object SetLose: GameBoardAction
    object SetIncorrectWord: GameBoardAction

}