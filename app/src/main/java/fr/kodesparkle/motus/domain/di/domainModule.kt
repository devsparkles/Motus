package fr.kodesparkle.motus.domain.di

import fr.kodesparkle.motus.domain.usecases.GetWordToGuessUseCase
import fr.kodesparkle.motus.domain.usecases.GetAllTheWordsUseCase
import fr.kodesparkle.motus.domain.usecases.GetWordStateUseCase
import fr.kodesparkle.motus.domain.usecases.IsUserGuessCorrectUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetWordToGuessUseCase() }
    factory { IsUserGuessCorrectUseCase() }
    factory { GetWordStateUseCase() }
    factory { GetAllTheWordsUseCase(get()) }
}