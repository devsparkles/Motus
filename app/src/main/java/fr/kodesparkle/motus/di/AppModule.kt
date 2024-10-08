package fr.kodesparkle.motus.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.kodesparkle.motus.data.repository.WordsRepositoryImpl
import fr.kodesparkle.motus.domain.repository.WordsRepository
import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module()
class AppModule {

    @Provides
    @Singleton
    fun provideWordleRepository(
        @ApplicationContext context: Context,
    ): WordsRepository =
        WordsRepositoryImpl(context,)

}