package fr.kodesparkle.motus.presentation.statistique

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import fr.kodesparkle.motus.navigation.MotusEvent
import fr.kodesparkle.motus.presentation.statistique.models.StatisticState
import fr.kodesparkle.motus.presentation.statistique.viewmodel.StatisticViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun StatisticRoute(
    viewModel: StatisticViewModel = koinViewModel(), onClickEvent: (MotusEvent) -> Unit
) {
    val state by viewModel.state.collectAsState(initial = StatisticState.None)

    StatisticScreen(
        Modifier, state, onClickEvent = onClickEvent
    )
}


/**
 * Statistic screen
 * @param viewModel the view model
 */
@Composable
fun StatisticScreen(
    modifier: Modifier = Modifier, state: StatisticState, onClickEvent: (MotusEvent) -> Unit = {}
) {

    when (state) {
        is StatisticState.Loading -> {
            // Loading state

        }

        is StatisticState.None -> {
            // None state

        }

        is StatisticState.Error -> {
            // Error state

        }


    }

}