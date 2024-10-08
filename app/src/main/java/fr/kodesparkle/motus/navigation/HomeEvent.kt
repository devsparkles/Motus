package fr.kodesparkle.motus.navigation

sealed interface MotusEvent {
    object GameBoard: MotusEvent
    object Statistic: MotusEvent
}
