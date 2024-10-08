package fr.kodesparkle.motus.data.repository

import android.content.Context
import fr.kodesparkle.motus.R
import fr.kodesparkle.motus.data.mapper.toWord
import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.repository.WordsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Singleton

@Singleton
class WordsRepositoryImpl(private val context:Context): WordsRepository {

    override suspend fun loadWords(): List<Word> {
        return withContext(Dispatchers.IO) {
            val inputStream = context.resources.openRawResource(R.raw.mots_de_motus)
            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                val listOfWords = mutableListOf<Word>()
                var mLine = reader.readLine()
                while (mLine != null) {
                    listOfWords.add(mLine.toWord()) // Convert each line to a Word object
                    mLine = reader.readLine()
                }
                listOfWords
            }
        }
    }
}