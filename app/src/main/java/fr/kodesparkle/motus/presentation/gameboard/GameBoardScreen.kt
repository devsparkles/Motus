package fr.kodesparkle.motus.presentation.gameboard

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import fr.kodesparkle.motus.navigation.MotusEvent
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardAction
import fr.kodesparkle.motus.presentation.gameboard.viewmodel.GameBoardViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun GameBoardRoute(
    viewModel: GameBoardViewModel = koinViewModel(), onClickEvent: (MotusEvent) -> Unit
) {
    val state by viewModel.state.collectAsState(initial = GameBoardState.None)

    GameBoardScreen(
        Modifier, state, onClickEvent = onClickEvent
    )
}


/**
 * Game board screen
 * @param viewModel the view model
 */
@Composable
fun GameBoardScreen(
    modifier: Modifier = Modifier,
    state: GameBoardState,
    onClickEvent: (MotusEvent) -> Unit = {}
) {
    when (state) {
        is GameBoardState.Loading -> {
            // Loading state
            CircularProgressIndicator()
        }
        is GameBoardState.None -> {
            // Empty state
        }
        is GameBoardState.Win -> {
            // Success state
        }
        is GameBoardState.IncorrectWord -> {
            // Error state
        }
        is GameBoardState.Lose -> {
            // Error state
        }
        is GameBoardState.Error -> {
            // Error state
        }

        is GameBoardState.Word -> {
            Text(text = state.word)
        }
    }

}