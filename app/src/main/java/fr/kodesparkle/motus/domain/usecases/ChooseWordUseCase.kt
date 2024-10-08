package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.domain.model.Word

/**
 * This use case will choose a word from the list of words
 */
class ChooseWordUseCase(
    private val getWordsUseCase: GetWordsUseCase
) {

    suspend operator fun invoke() : Word {
        val words = getWordsUseCase()
        return words.random()
    }
}