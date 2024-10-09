package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.arch.UseCase
import fr.kodesparkle.motus.domain.params.VerifyWordIsGoodParam

/*
 * This use case will verify if the word is good
 */
class IsUserGuessCorrectUseCase : UseCase.Parameterized<VerifyWordIsGoodParam, Boolean> {

    override operator fun invoke(param: VerifyWordIsGoodParam): Boolean {
        return param.currentWord == param.selectedWord
    }
}