package fr.kodesparkle.motus.presentation.gameboard

import androidx.lifecycle.ViewModel
import fr.kodesparkle.motus.domain.usecases.ChooseWordUseCase
import fr.kodesparkle.motus.domain.usecases.GetWordsUseCase
import fr.kodesparkle.motus.domain.usecases.MarkWordWithCorrectStateUseCase
import fr.kodesparkle.motus.domain.usecases.VerifyWordIsGoodUseCase

class GameBoardViewModel(
    val getWordsUseCase: GetWordsUseCase,
    val chooseWordUseCase: ChooseWordUseCase,
    val verifyWordIsGoodUseCase: VerifyWordIsGoodUseCase,
    val markWordWithCorrectStateUseCase: MarkWordWithCorrectStateUseCase
) : ViewModel() {


}