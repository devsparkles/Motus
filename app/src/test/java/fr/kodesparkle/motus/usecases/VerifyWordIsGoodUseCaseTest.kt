package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.params.VerifyWordIsGoodParam
import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VerifyWordIsGoodUseCaseTest {

    private val verifyWordIsGoodUseCase = VerifyWordIsGoodUseCase()

    @Test
    fun `invoke should return true when currentWord is equal to selectedWord`() {
        // Given
        val param = VerifyWordIsGoodParam(
            currentWord = "Kotlin",
            selectedWord = "Kotlin"
        )

        // When
        val result = verifyWordIsGoodUseCase.invoke(param)

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
        val result = verifyWordIsGoodUseCase.invoke(param)

        // Then
        assertFalse(result, "Expected false when currentWord is not equal to selectedWord")
    }
}