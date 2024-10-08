package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase
import org.junit.Assert.*
import org.junit.Test

class VerifyWordIsGoodUseCaseTest {

    private val verifyWordIsGoodUseCase = VerifyWordIsGoodUseCase()

    @Test
    fun `invoke returns true when words are the same`() {
        // Arrange
        val currentWord = "apple"
        val selectedWord = "apple"

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `invoke returns false when words are different`() {
        // Arrange
        val currentWord = "apple"
        val selectedWord = "grape"

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `invoke returns false when currentWord is empty`() {
        // Arrange
        val currentWord = ""
        val selectedWord = "apple"

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `invoke returns false when selectedWord is empty`() {
        // Arrange
        val currentWord = "apple"
        val selectedWord = ""

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `invoke returns true when both words are empty`() {
        // Arrange
        val currentWord = ""
        val selectedWord = ""

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `invoke returns false when words have different casing`() {
        // Arrange
        val currentWord = "Apple"
        val selectedWord = "apple"

        // Act
        val result = verifyWordIsGoodUseCase(currentWord, selectedWord)

        // Assert
        assertFalse(result)
    }
}
