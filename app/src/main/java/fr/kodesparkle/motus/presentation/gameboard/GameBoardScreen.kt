package fr.kodesparkle.motus.presentation.gameboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
                // yello if the letter is existent in the selected word
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

            }
        }
    }

}

@Composable
fun GameBoard(word: String, onGuessSubmitted: (String) -> Unit) {
    var currentGuess by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Display the word with only the first letter revealed
        Text(
            text = word.first() + "_".repeat(word.length - 1),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Input field for user guess
        OutlinedTextField(
            value = currentGuess,
            onValueChange = {
                if (it.length <= word.length) currentGuess = it.uppercase()
            },
            label = { Text("Enter your guess") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                if (currentGuess.length == word.length) {
                    onGuessSubmitted(currentGuess)
                    currentGuess = ""
                }
            })
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button
        Button(
            onClick = {
                if (currentGuess.length == word.length) {
                    onGuessSubmitted(currentGuess)
                    currentGuess = ""
                }
            }, enabled = currentGuess.length == word.length
        ) {
            Text("Submit Guess")
        }
    }
}