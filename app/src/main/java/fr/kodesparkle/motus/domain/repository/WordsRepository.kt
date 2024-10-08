package fr.kodesparkle.motus.domain.repository

import fr.kodesparkle.motus.domain.model.Word

interface WordsRepository {
    // Allow to load the words from local
    suspend fun loadWords(): List<Word>
}