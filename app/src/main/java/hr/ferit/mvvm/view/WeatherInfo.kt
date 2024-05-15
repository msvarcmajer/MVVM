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
import androidx.navigation.NavController
import hr.ferit.mvvm.model.WeatherData

@Composable
fun WeatherInfo(weatherData: WeatherData, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Weather Info",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Temperature: ${weatherData.temperature}")
        Text("Humidity: ${weatherData.humidity}")
        Text("Wind Speed: ${weatherData.windSpeed}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Back")
        }
    }
}
