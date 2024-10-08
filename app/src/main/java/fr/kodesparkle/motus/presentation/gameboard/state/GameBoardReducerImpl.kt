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

                is GameBoardAction.SetWord -> GameBoardState.Playing(action.word)

                is GameBoardAction.SetWin -> GameBoardState.Win(action.correctWord)

                // When the user already tried 7 times - he/she lose and the correct word is displayed
                is GameBoardAction.SetAllAttemptOver -> GameBoardState.Lose(action.correctWord)

                // when the user put a word that do not exist in the dictionnary - he/she lose and the correct word is displayed
                // with a message explaining when he/she lost
                is GameBoardAction.SetNonExistentWord -> GameBoardState.NonExistentWord

                // when the user find a word in the dictionary but it's not the right one we keep the current word in memory
                // and we move to the next attempt
                is GameBoardAction.SetIncorrectGuess -> GameBoardState.IncorrectGuess(action.currentWord)
            }
        }
    }
}
