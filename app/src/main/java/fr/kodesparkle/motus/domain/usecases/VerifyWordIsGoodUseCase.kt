package fr.kodesparkle.motus.domain.usecases

import javax.inject.Inject

/*
 * This use case will verify if the word is good
 */
class VerifyWordIsGoodUseCase @Inject constructor() {

    operator fun invoke(currentWord: String, selectedWord: String): Boolean {
        return currentWord == selectedWord
    }
}