package fr.kodesparkle.motus.presentation.statistique.viewmodel

import androidx.lifecycle.ViewModel
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState
import fr.kodesparkle.motus.presentation.statistique.models.StatisticState
import kotlinx.coroutines.flow.Flow

abstract class StatisticViewModel : ViewModel() {
    abstract val state: Flow<StatisticState>

}
