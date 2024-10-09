package fr.kodesparkle.motus.usecases

import fr.kodesparkle.motus.domain.model.LetterState
import fr.kodesparkle.motus.domain.params.GetWordStateParam
import fr.kodesparkle.motus.domain.usecases.GetWordStateUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GetWordStateUseCaseTest {

    private val sut = GetWordStateUseCase()

    @Test
    fun `verify all letters well placed`() = runTest {
        // given
        val param = GetWordStateParam(correctWord = "hello", userWord = "hello")

        // when
        val result = sut.invoke(param)

        // then
        val expected = mapOf(
            'h' to LetterState.WELL_PLACED,
            'e' to LetterState.WELL_PLACED,
            'l' to LetterState.WELL_PLACED,
            'l' to LetterState.WELL_PLACED,
            'o' to LetterState.WELL_PLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `verify all letters misplaced`() = runTest {
        // given
        val param = GetWordStateParam(correctWord = "broue", userWord = "eubro")

        // when
        val result = sut.invoke(param)

        // then
        val expected = mapOf(
            'b' to LetterState.MISPLACED,
            'r' to LetterState.MISPLACED,
            'o' to LetterState.MISPLACED,
            'u' to LetterState.MISPLACED,
            'e' to LetterState.MISPLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `verify all letters not in word`() = runTest {
        // given
        val param = GetWordStateParam(correctWord = "hello", userWord = "btrin")

        // when
        val result = sut.invoke(param)

        // then
        val expected = mapOf(
            'h' to LetterState.NOT_IN_WORD,
            'e' to LetterState.NOT_IN_WORD,
            'l' to LetterState.NOT_IN_WORD,
            'l' to LetterState.NOT_IN_WORD,
            'o' to LetterState.NOT_IN_WORD
        )
        assertEquals(expected, result)
    }

    @Test
    fun `verify mixed letter states`() = runTest {
        // given
        val param = GetWordStateParam(correctWord = "hello", userWord = "ehllo")

        // when
        val result = sut.invoke(param)

        // then
        val expected = mapOf(
            'h' to LetterState.MISPLACED,
            'e' to LetterState.MISPLACED,
            'l' to LetterState.WELL_PLACED,
            'l' to LetterState.WELL_PLACED,
            'o' to LetterState.WELL_PLACED
        )
        assertEquals(expected, result)
    }

    @Test
    fun `verify repeated letters in correct word`() = runTest {
        // given
        val param = GetWordStateParam(correctWord = "hello", userWord = "hhllw")

        // when
        val result = sut.invoke(param)

        // then
        val expected = mapOf(
            'h' to LetterState.WELL_PLACED,
            'e' to LetterState.MISPLACED,
            'l' to LetterState.WELL_PLACED,
            'l' to LetterState.WELL_PLACED,
            'o' to LetterState.NOT_IN_WORD,
        )
        assertEquals(expected, result)
    }
}