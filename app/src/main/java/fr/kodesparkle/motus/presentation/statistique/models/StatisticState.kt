package fr.kodesparkle.motus.presentation.statistique.models

import fr.kodesparkle.motus.arch.State

sealed interface StatisticState : State {
    object Loading: StatisticState
    object None: StatisticState
    data class Error(val message: String): StatisticState
}
