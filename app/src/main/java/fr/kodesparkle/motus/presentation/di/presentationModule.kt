package fr.kodesparkle.motus.presentation.di

import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardReducer
import fr.kodesparkle.motus.presentation.gameboard.state.GameBoardReducerImpl
import fr.kodesparkle.motus.presentation.gameboard.viewmodel.GameBoardViewModel
import fr.kodesparkle.motus.presentation.gameboard.viewmodel.GameBoardViewModelImpl
import fr.kodesparkle.motus.presentation.statistique.state.StatisticReducer
import fr.kodesparkle.motus.presentation.statistique.state.StatisticReducerImpl
import fr.kodesparkle.motus.presentation.statistique.viewmodel.StatisticViewModel
import fr.kodesparkle.motus.presentation.statistique.viewmodel.StatisticViewModelImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val presentationModule = module {
    // GameBoard
    factory<GameBoardReducer> { GameBoardReducerImpl(get()) } bind GameBoardReducer::class
    factory<GameBoardViewModel> {
        GameBoardViewModelImpl(
            get(),
            get(),
            get(),
            get()
        )
    } bind GameBoardViewModel::class



    // Statistic
    factory<StatisticReducer> { StatisticReducerImpl(get()) } bind StatisticReducer::class
    factory<StatisticViewModel> {
        StatisticViewModelImpl(
            get(),
            get()
        )
    } bind StatisticViewModel::class


}