package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.model.LetterState
import fr.kodesparkle.motus.domain.usecases.MarkWordWithCorrectStateUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class MarkWordWithCorrectStateUseCaseTest {

    @Test
    fun `invoke returns correct states for a well-placed word`() {
        // Arrange
        val userWord = "apple"
        val correctWord = "apple"
        val useCase = MarkWordWithCorrectStateUseCase(userWord, correctWord)

        // Act
        val result = useCase()

        // Assert
        val expected = mapOf(
            'a' to LetterState.WELL_PLACED,
            'p' to LetterState.WELL_PLACED,
            'l' to LetterState.WELL_PLACED,
            'e' to LetterState.WELL_PLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `invoke returns correct states for misplaced letters`() {
        // Arrange
        val userWord = "pplae"
        val correctWord = "apple"
        val useCase = MarkWordWithCorrectStateUseCase(userWord, correctWord)

        // Act
        val result = useCase()

        // Assert
        val expected = mapOf(
            'p' to LetterState.WELL_PLACED,
            'p' to LetterState.WELL_PLACED,
            'l' to LetterState.MISPLACED,
            'a' to LetterState.MISPLACED,
            'e' to LetterState.WELL_PLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `invoke returns correct states for letters not in the word`() {
        // Arrange
        val userWord = "grape"
        val correctWord = "apple"
        val useCase = MarkWordWithCorrectStateUseCase(userWord, correctWord)

        // Act
        val result = useCase()

        // Assert
        val expected = mapOf(
            'g' to LetterState.NOT_IN_WORD,
            'r' to LetterState.NOT_IN_WORD,
            'a' to LetterState.MISPLACED,
            'p' to LetterState.WELL_PLACED,
            'e' to LetterState.WELL_PLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `invoke returns correct states for mixed well placed, misplaced, and missing letters`() {
        // Arrange
        val userWord = "plead"
        val correctWord = "apple"
        val useCase = MarkWordWithCorrectStateUseCase(userWord, correctWord)

        // Act
        val result = useCase()

        // Assert
        val expected = mapOf(
            'p' to LetterState.WELL_PLACED,
            'l' to LetterState.MISPLACED,
            'e' to LetterState.WELL_PLACED,
            'a' to LetterState.MISPLACED,
            'd' to LetterState.NOT_IN_WORD
        )
        assertEquals(expected, result)
    }
}
