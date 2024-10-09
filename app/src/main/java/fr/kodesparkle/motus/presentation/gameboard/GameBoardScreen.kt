package fr.kodesparkle.motus.presentation.gameboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import fr.kodesparkle.motus.navigation.MotusEvent
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import fr.kodesparkle.motus.presentation.gameboard.viewmodel.GameBoardViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun GameBoardRoute(
    viewModel: GameBoardViewModel = koinViewModel(), onClickEvent: (MotusEvent) -> Unit
) {
    val state by viewModel.state.collectAsState(initial = GameBoardState.None)

    GameBoardScreen(
        modifier = Modifier, state = state, onSubmitClicked = viewModel::onSubmitClicked
    )
}


/**
 * Game board screen
 * @param viewModel the view model
 */
@Composable
fun GameBoardScreen(
    modifier: Modifier = Modifier, state: GameBoardState, onSubmitClicked: (guess: String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        when (state) {
            is GameBoardState.Loading -> {
                CircularProgressIndicator()
            }

            is GameBoardState.None -> {
                Text("Game not started")
            }

            is GameBoardState.Win -> {
                Text("Congratulations! You won!")
            }

            is GameBoardState.IncorrectGuess -> {
                // display here the attempt with the right color
                // white background if the letter is not existent in the selected word
                // yellow if the letter is existent in the selected word
                // green if the letter is in the selected word and at the right position
                Text("Incorrect word. Try again!")
            }

            is GameBoardState.Lose -> {
                // displayed when 7 attempts are tried and the word still not found
                Text("Game over. The word was: ${state.correctWord}")
            }

            is GameBoardState.Error -> {
                Text("An error occurred: ${state.message}")
            }

            GameBoardState.NonExistentWord -> {
                // when the user put a word that do not exist in the dictionary the player automatically lose
                Text("That word do not exist you lose word")
            }

            is GameBoardState.Playing -> {

                Column {
                    Text("Playing")
                    Text(state.currentWord)
                }

            }
        }
    }

}

