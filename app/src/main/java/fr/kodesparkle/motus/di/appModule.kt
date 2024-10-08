package fr.kodesparkle.motus.di

import fr.kodesparkle.motus.data.di.dataModule
import fr.kodesparkle.motus.di.coroutines.CoroutineDispatcherProvider
import fr.kodesparkle.motus.di.coroutines.DispatcherProvider
import fr.kodesparkle.motus.domain.di.domainModule
import fr.kodesparkle.motus.presentation.di.presentationModule
import org.koin.core.module.Module
import org.koin.dsl.module

val kotlinCoroutinesProvidersModule = module {
    factory<DispatcherProvider> { CoroutineDispatcherProvider() }
}


val appModules: List<Module> = listOf(
    dataModule,
    domainModule,
    presentationModule,
    kotlinCoroutinesProvidersModule
)


