package fr.kodesparkle.motus.domain.repository

interface WordsRepository {
    // Allow to load the words from local
    fun loadWords(): List<String>
}