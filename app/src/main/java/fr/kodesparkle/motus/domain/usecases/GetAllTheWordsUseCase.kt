package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.arch.UseCase
import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.repository.WordsRepository

/**
 * Load words from the repository
 */
class GetAllTheWordsUseCase(private val wordsRepository: WordsRepository): UseCase.Suspending<List<Word>> {

    override suspend operator fun invoke() : List<Word> {
        return wordsRepository.loadWords()
    }
}