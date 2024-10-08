package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.domain.model.LetterState

/**
 * This use case will take a word from the user and the correct word
 * and produce a hashmap that contain the letter, enum representing the state of the letter for example
 * l, well placed ; e,  misplaced ; r, not in the word
 */
class MarkWordWithCorrectStateUseCase(
    private val userWord: String,
    private val correctWord: String
) {

    operator fun invoke(): Map<Char, LetterState> {
        val result = mutableMapOf<Char, LetterState>()
        val correctWord = correctWord.toCharArray()
        val userWord = userWord.toCharArray()
        for (i in correctWord.indices) {
            if (correctWord[i] == userWord[i]) {
                result[correctWord[i]] = LetterState.WELL_PLACED
            } else if (correctWord.contains(userWord[i])) {
                result[correctWord[i]] = LetterState.MISPLACED
            } else {
                result[correctWord[i]] = LetterState.NOT_IN_WORD
            }
        }
        return result
    }
}


