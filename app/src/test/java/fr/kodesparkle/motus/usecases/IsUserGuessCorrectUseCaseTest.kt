package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.params.VerifyWordIsGoodParam
import fr.kodesparkle.motus.domain.usecases.IsUserGuessCorrectUseCase
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsUserGuessCorrectUseCaseTest {

    private val isUserGuessCorrectUseCase = IsUserGuessCorrectUseCase()

    @Test
    fun `invoke should return true when currentWord is equal to selectedWord`() {
        // Given
        val param = VerifyWordIsGoodParam(
            currentWord = "Kotlin",
            selectedWord = "Kotlin"
        )

        // When
        val result = isUserGuessCorrectUseCase.invoke(param)

        // Then
        assertTrue(result, "Expected true when currentWord is equal to selectedWord")
    }

    @Test
    fun `invoke should return false when currentWord is not equal to selectedWord`() {
        // Given
        val param = VerifyWordIsGoodParam(
            currentWord = "Kotlin",
            selectedWord = "Java"
        )

        // When
        val result = isUserGuessCorrectUseCase.invoke(param)

        // Then
        assertFalse(result, "Expected false when currentWord is not equal to selectedWord")
    }
}