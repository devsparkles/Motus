package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.arch.UseCase
import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.repository.WordsRepository

/**
 * This use case load words from the repository
 */
class LoadWordsUseCase(private val wordsRepository: WordsRepository): UseCase.Suspending<List<Word>> {

    override suspend operator fun invoke() : List<Word> {
        return wordsRepository.loadWords()
    }
}