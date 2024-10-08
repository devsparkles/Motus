package fr.kodesparkle.motus.data.di

import fr.kodesparkle.motus.data.repository.WordsRepositoryImpl
import fr.kodesparkle.motus.domain.repository.WordsRepository
import org.koin.dsl.module

val dataModule = module {
    // Data sources
    factory<WordsRepository> { WordsRepositoryImpl(get()) }
}
