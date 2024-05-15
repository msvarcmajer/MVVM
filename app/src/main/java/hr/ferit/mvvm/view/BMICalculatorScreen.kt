package hr.ferit.mvvm.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavController

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hr.ferit.mvvm.viewmodel.BMIViewModel

@Composable
fun BMICalculatorScreen(navController: NavController, viewModel: BMIViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        BackgroundImage(modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var weight by remember { mutableStateOf("") }
            var height by remember { mutableStateOf("") }
            var bmiResult by remember { mutableStateOf<Float?>(null) }

            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Izracun preko viewmodela
                    bmiResult = viewModel.calculateBMI(weight.toFloatOrNull(), height.toFloatOrNull())
                }
            ) {
                Text("Calculate BMI")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display BMI result
            Text(
                text = "Your BMI: ${bmiResult?.toString() ?: "N/A"}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        // Dodajte gumb za prebacivanje na Weather Info
        Button(
            onClick = { navController.navigate("weather_info") },
            modifier = Modifier
                .align(Alignment.BottomStart) // Poravnanje u donji lijevi kut
                .padding(16.dp) // Dodatni razmak od ruba ekrana
        ) {
            Text("Weather Info")
        }
    }
}
