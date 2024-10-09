package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.repository.WordsRepository
import fr.kodesparkle.motus.domain.usecases.LoadWordsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LoadWordsUseCaseTest {

    private val wordsRepository = mockk<WordsRepository>()
    private val loadWordsUseCase = LoadWordsUseCase(wordsRepository)

    @Test
    fun `invoke should return list of words from repository`() = runTest {
        // Given
        val expectedWords = listOf(Word("Kotlin"), Word("Coroutines"), Word("Flow"))
        coEvery { wordsRepository.loadWords() } returns expectedWords

        // When
        val words = loadWordsUseCase.invoke()

        // Then
        assertEquals(expectedWords, words, "Returned words should match the ones from the repository")
    }
}