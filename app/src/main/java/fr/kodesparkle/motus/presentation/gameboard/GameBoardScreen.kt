package fr.kodesparkle.motus.presentation.gameboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import fr.kodesparkle.motus.presentation.gameboard.components.HeaderBar
import org.w3c.dom.Text

// that composable will have the game board screen
// it will have just a textfield to enter the word and a button to submit the word
// and a list of letters that will be displayed in the screen
// the list of letters will be displayed in a row
// each letter will have a different color depending on the state of the letter
// the state of the letter can be one of the following:
// - WELL_PLACED: the letter is in the right place
// - MISPLACED: the letter is in the word but not in the right place
// - NOT_IN_WORD: the letter is not in the word
/**
 * Game board screen
 * @param viewModel the view model
 */
@Composable
fun GameBoardScreen(
    viewModel: GameBoardViewModel = hiltViewModel(),

) {

    val loading by viewModel.loading.observeAsState()
    val selectedWord by viewModel.selectedWord.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray.copy(alpha = 0.5f))
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier

                .fillMaxSize()
        ) {
            HeaderBar()
            if (loading != null && loading == true) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(30.dp),
                        color = Color.Blue,
                        strokeWidth = 3.dp
                    )
                }
            } else {
                // here we will display the first letter of the word
                // and 8 empty boxes
                // the user will have to enter the word in the textfield
                // and click on the submit button
                // when the user clicks on the submit button
                // we will check if the word is correct
                // if the word is correct we will display a dialog that will tell the user that he won
                // if the word do not exist in our dictionnary we will display a dialog that will tell the user that he lost
                // if the word is incorrect we will display the letters in the row with the correct colors




            }
        }
    }


}