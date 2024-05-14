package hr.ferit.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.ferit.mvvm.model.WeatherModel
import hr.ferit.mvvm.repository.WeatherApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherService = WeatherApiHelper.createWeatherService()
    var weatherData: WeatherModel? = null

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                weatherData = weatherService.getWeather()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
