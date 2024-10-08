package fr.kodesparkle.motus.presentation.gameboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.kodesparkle.motus.domain.model.LetterState

@Composable
fun LetterRow(list: List<LetterState>) {


    Box{
        Row {

            list.forEach { letterState ->
                Letter(letterState = letterState)
            }
        }
    }

}


@Composable
fun Letter(letterState: LetterState) {
    Box {
        when (letterState) {
            LetterState.WELL_PLACED -> {
                Box(
                    modifier = androidx.compose.ui.Modifier
                        .size(50.dp)
                        .background(color = Color.Green)
                )
            }
            LetterState.MISPLACED -> {
                Box(
                    modifier = androidx.compose.ui.Modifier
                        .size(50.dp)
                        .background(color = Color.Yellow)
                )
            }
            LetterState.NOT_IN_WORD -> {
                Box(
                    modifier = androidx.compose.ui.Modifier
                        .size(50.dp)
                        .background(color = Color.Red)
                )
            }
        }
    }
}