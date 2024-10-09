package fr.kodesparkle.motus.presentation.gameboard.viewmodel

import androidx.lifecycle.viewModelScope
import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.domain.params.IsUserGuessCorrectParam
import fr.kodesparkle.motus.domain.usecases.GetWordToGuessUseCase
import fr.kodesparkle.motus.domain.usecases.GetAllTheWordsUseCase
import fr.kodesparkle.motus.domain.usecases.IsUserGuessCorrectUseCase
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardAction
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardReducer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameBoardViewModelImpl(
    private val getAllTheWordsUseCase: GetAllTheWordsUseCase,
    private val getWordToGuessUseCase: GetWordToGuessUseCase,
    private val isUserGuessCorrectUseCase: IsUserGuessCorrectUseCase,
    private val reducer: GameBoardReducer,
    private val dispatcherProvider: DispatcherProvider
) : GameBoardViewModel() {

    override val state = reducer.state

    init {
        startGame()
    }

    private fun startGame() {
        viewModelScope.launch(dispatcherProvider.io) {
            reducer.update(GameBoardAction.SetLoading)
            val words = getAllTheWordsUseCase()
            val word = getWordToGuessUseCase(words)
            reducer.update(GameBoardAction.SetWord(word.content))
        }
    }

    override fun onSubmitClicked(guess: String) {
        viewModelScope.launch(dispatcherProvider.io) {
            state.collectLatest { state ->
                if (state is GameBoardState.Playing) {
                    val result  = isUserGuessCorrectUseCase(IsUserGuessCorrectParam(currentWord = state.currentWord, selectedWord = guess))
                    if (result) {
                        reducer.update(GameBoardAction.SetWin(state.currentWord))
                    } else {
                        reducer.update(GameBoardAction.SetIncorrectGuess(state.currentWord))
                    }
                }
            }
        }
    }


    private companion object {
        const val TAG = "GameBoardViewModelImpl"
    }
}