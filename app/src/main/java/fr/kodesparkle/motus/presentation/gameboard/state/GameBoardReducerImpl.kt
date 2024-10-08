package fr.kodesparkle.motus.presentation.gameboard.state

import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class GameBoardReducerImpl(
    private val dispatcherProvider: DispatcherProvider
) : GameBoardReducer {

    override val state: MutableStateFlow<GameBoardState> = MutableStateFlow(GameBoardState.None)

    override suspend fun update(action: GameBoardAction) {
        withContext(dispatcherProvider.default) {
            state.value = when (action) {
                GameBoardAction.SetLoading -> GameBoardState.Loading
                is GameBoardAction.SetWord -> GameBoardState.Word(action.word)
                is GameBoardAction.SetWin -> GameBoardState.Win
                is GameBoardAction.SetLose -> GameBoardState.Lose
                is GameBoardAction.SetIncorrectWord -> GameBoardState.IncorrectWord
            }
        }
    }
}
