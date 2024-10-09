package fr.kodesparkle.motus.domain.repository

import fr.kodesparkle.motus.domain.model.Word

interface WordsRepository {
    /**
     * Load the words from the raw ressource folder
     */
    suspend fun loadWords(): List<Word>
}