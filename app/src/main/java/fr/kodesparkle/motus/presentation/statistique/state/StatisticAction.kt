package fr.kodesparkle.motus.presentation.statistique.state

import fr.kodesparkle.motus.arch.Action


sealed interface StatisticAction : Action {
    object SetLoading: StatisticAction


}