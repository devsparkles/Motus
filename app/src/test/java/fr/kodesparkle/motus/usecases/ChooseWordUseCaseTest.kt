package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.usecases.ChooseWordUseCase
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ChooseWordUseCaseTest {

    private val chooseWordUseCase = ChooseWordUseCase()

    @Test
    fun `invoke should return a word from the list`() = runTest {
        // Given
        val words = listOf(Word("Hello"), Word("World"), Word("Test"))

        // When
        val selectedWord = chooseWordUseCase.invoke(words)

        // Then
        assertTrue(selectedWord in words, "Selected word should be in the given list of words")
    }
}