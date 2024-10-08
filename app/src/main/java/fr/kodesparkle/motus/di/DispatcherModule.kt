package fr.kodesparkle.motus.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.kodesparkle.motus.di.annotations.DefaultDispatcher
import fr.kodesparkle.motus.di.annotations.IoDispatcher
import fr.kodesparkle.motus.di.annotations.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * some dispatchers here are not used but could be used in the future .
 */
@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}

