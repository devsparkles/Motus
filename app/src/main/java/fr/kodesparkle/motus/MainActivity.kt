package fr.kodesparkle.motus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.kodesparkle.motus.navigation.GameBoardDestination
import fr.kodesparkle.motus.navigation.MotusEvent
import fr.kodesparkle.motus.navigation.StatisticDestination
import fr.kodesparkle.motus.presentation.gameboard.GameBoardRoute
import fr.kodesparkle.motus.presentation.gameboard.GameBoardScreen
import fr.kodesparkle.motus.presentation.statistique.StatisticRoute
import fr.kodesparkle.motus.ui.theme.MotusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            MotusTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = GameBoardDestination.route) {
                    composable(GameBoardDestination.route) {
                        GameBoardRoute { motusEvent ->
                            handleMotusEvent(motusEvent, navController)
                        }
                    }
                    composable(StatisticDestination.route) {
                        StatisticRoute { motusEvent ->
                            handleMotusEvent(motusEvent, navController)
                        }
                    }
                }
            }
        }
    }


    private fun handleMotusEvent(homeEvent: MotusEvent, navController: NavHostController) {
        when (homeEvent) {
            MotusEvent.GameBoard -> navController.navigate(GameBoardDestination.route)
            MotusEvent.Statistic -> navController.navigate(StatisticDestination.route)
        }
    }


}
