package fr.kodesparkle.motus.presentation.gameboard.state

import fr.kodesparkle.motus.arch.Reducer
import fr.kodesparkle.motus.presentation.gameboard.models.GameBoardState

interface GameBoardReducer : Reducer<GameBoardState, GameBoardAction>
