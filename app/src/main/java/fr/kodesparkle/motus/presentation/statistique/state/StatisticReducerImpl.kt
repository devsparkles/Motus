package fr.kodesparkle.motus.presentation.statistique.state

import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.presentation.statistique.models.StatisticState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class StatisticReducerImpl(
    private val dispatcherProvider: DispatcherProvider
) : StatisticReducer {

    override val state: MutableStateFlow<StatisticState> = MutableStateFlow(StatisticState.None)

    override suspend fun update(action: StatisticAction) {
        withContext(dispatcherProvider.default) {
            state.value = when (action) {
                StatisticAction.SetLoading -> StatisticState.Loading
            }
        }
    }
}
