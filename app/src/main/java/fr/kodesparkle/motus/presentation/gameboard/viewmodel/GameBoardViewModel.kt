package fr.kodesparkle.motus.presentation.gameboard.viewmodel

import androidx.lifecycle.ViewModel
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import kotlinx.coroutines.flow.Flow

abstract class GameBoardViewModel : ViewModel() {
    abstract val state: Flow<GameBoardState>


    abstract fun onSubmitClicked(guess: String)
}
