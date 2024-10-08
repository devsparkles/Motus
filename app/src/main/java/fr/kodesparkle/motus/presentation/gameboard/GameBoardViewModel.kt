package fr.kodesparkle.motus.presentation.gameboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.kodesparkle.motus.di.annotations.IoDispatcher
import fr.kodesparkle.motus.domain.model.Word
import fr.kodesparkle.motus.domain.usecases.ChooseWordUseCase
import fr.kodesparkle.motus.domain.usecases.GetWordsUseCase
import fr.kodesparkle.motus.domain.usecases.MarkWordWithCorrectStateUseCase
import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

@HiltViewModel
class GameBoardViewModel(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    val chooseWordUseCase: ChooseWordUseCase,
    val verifyWordIsGoodUseCase: VerifyWordIsGoodUseCase,
    val markWordWithCorrectStateUseCase: MarkWordWithCorrectStateUseCase
) : ViewModel() {
    val _loading: MutableLiveData<Boolean> = MutableLiveData(true)
    val loading: LiveData<Boolean> = _loading

    val _selectedWord : MutableLiveData<Word> = MutableLiveData()
    val selectedWord: LiveData<Word> = _selectedWord

    init {
        startGame()
    }

    private fun startGame() {
        viewModelScope.launch(ioDispatcher) {
            _loading.postValue(true)
            val word = chooseWordUseCase()
            _selectedWord.postValue(word)
            _loading.postValue(false)
        }
    }
}