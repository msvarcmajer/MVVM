package hr.ferit.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.ferit.mvvm.view.BMICalculatorScreen
import hr.ferit.mvvm.view.BackgroundImage
import hr.ferit.mvvm.view.WeatherScreen
import hr.ferit.mvvm.viewmodel.BMIViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "bmi_calculator") {
                composable("bmi_calculator") {
                    BMICalculatorScreen(navController = navController, viewModel = BMIViewModel())
                }

                composable("weather_screen") {
                    WeatherScreen(navController= navController)
                }
            }
        }
    }
}
