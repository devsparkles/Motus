package fr.kodesparkle.motus.domain.usecases

/*
 * This use case will verify if the word is good
 */
class VerifyWordIsGoodUseCase constructor() {

    operator fun invoke(currentWord: String, selectedWord: String): Boolean {
        return currentWord == selectedWord
    }
}