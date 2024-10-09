package fr.kodesparkle.motus.presentation.gameboard.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.domain.usecases.ChooseWordUseCase
import fr.kodesparkle.motus.domain.usecases.LoadWordsUseCase
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardAction
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardReducer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameBoardViewModelImpl(
    private val loadWordsUseCase: LoadWordsUseCase,
    private val chooseWordUseCase: ChooseWordUseCase,
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
            val words = loadWordsUseCase()
            val word = chooseWordUseCase(words)
            reducer.update(GameBoardAction.SetWord(word.content))
        }
    }

    override fun onSubmitClicked(guess: String) {
        viewModelScope.launch(dispatcherProvider.io) {
            state.collectLatest { state ->
                if (state is GameBoardState.Playing) {
                    Log.i(TAG, guess)
                    if (state.currentWord == guess) {
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