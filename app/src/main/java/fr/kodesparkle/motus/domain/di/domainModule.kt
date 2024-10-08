package fr.kodesparkle.motus.domain.di

import fr.kodesparkle.motus.domain.usecases.ChooseWordUseCase
import fr.kodesparkle.motus.domain.usecases.LoadWordsUseCase
import fr.kodesparkle.motus.domain.usecases.MarkWordWithCorrectStateUseCase
import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { ChooseWordUseCase() }
    factory { VerifyWordIsGoodUseCase() }
    factory { MarkWordWithCorrectStateUseCase() }
    factory { LoadWordsUseCase(get()) }
}