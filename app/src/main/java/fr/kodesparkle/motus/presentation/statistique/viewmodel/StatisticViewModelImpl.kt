package fr.kodesparkle.motus.presentation.statistique.viewmodel

import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.presentation.statistique.state.StatisticReducer

class StatisticViewModelImpl(
    private val reducer: StatisticReducer, private val dispatcherProvider: DispatcherProvider
) : StatisticViewModel() {

    override val state = reducer.state

    init {

    }


    private companion object {
        const val TAG = "StatisticViewModelImpl"
    }
}