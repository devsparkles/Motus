package fr.kodesparkle.motus.data.repository

import android.content.Context
import fr.kodesparkle.motus.R
import fr.kodesparkle.motus.domain.repository.WordsRepository
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Singleton

@Singleton
class WordsRepositoryImpl(private val context:Context): WordsRepository {

    override fun loadWords(): List<String> {
        val reader =
            BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.mots_de_motus)))
        val listOfWords = mutableListOf<String>()
        var mLine = reader.readLine()
        while (mLine != null) {
            listOfWords.add(mLine)
            mLine = reader.readLine()
        }
        reader.close()
        return listOfWords
    }
}