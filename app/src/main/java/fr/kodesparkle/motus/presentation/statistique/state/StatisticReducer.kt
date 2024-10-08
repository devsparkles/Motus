package fr.kodesparkle.motus.presentation.statistique.state

import fr.kodesparkle.motus.arch.Reducer
import fr.kodesparkle.motus.presentation.statistique.models.StatisticState

interface StatisticReducer : Reducer<StatisticState, StatisticAction>
