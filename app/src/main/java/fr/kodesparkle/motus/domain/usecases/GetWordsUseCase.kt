package fr.kodesparkle.motus.domain.usecases

import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.repository.WordsRepository
import javax.inject.Inject

/**
 * This use case will allow to get the words from the repository
 */
class GetWordsUseCase @Inject constructor(private val wordsRepository: WordsRepository) {

    suspend operator fun invoke() : List<Word> {
        return wordsRepository.loadWords()
    }
}