package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.arch.UseCase
import fr.kodesparkle.motus.domain.model.Word

/**
 * This use case choose randomly a word from a list of words
 */
class ChooseWordUseCase : UseCase.SuspendingParameterized<List<Word>, Word>{
    override suspend operator fun invoke(param: List<Word>) : Word {
        return param.random()
    }
}