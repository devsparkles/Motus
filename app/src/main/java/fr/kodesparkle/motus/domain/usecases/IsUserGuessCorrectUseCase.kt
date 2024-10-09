package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.arch.UseCase
import fr.kodesparkle.motus.domain.params.IsUserGuessCorrectParam

/*
 * This use case will verify if the word is good
 */
class IsUserGuessCorrectUseCase : UseCase.Parameterized<IsUserGuessCorrectParam, Boolean> {

    override operator fun invoke(param: IsUserGuessCorrectParam): Boolean {
        return param.currentWord == param.selectedWord
    }
}