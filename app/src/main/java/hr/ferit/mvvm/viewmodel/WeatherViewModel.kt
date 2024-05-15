package hr.ferit.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.ferit.mvvm.api.WeatherService
import hr.ferit.mvvm.model.WeatherData
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

class WeatherViewModel : ViewModel() {
    private val weatherService: WeatherService = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(WeatherService::class.java)

    private val apiKey = "01fad58656f6068550af9a6540ebf121"

    private val _weatherDataList = MutableLiveData<List<WeatherData>>()
    val weatherDataList: LiveData<List<WeatherData>> = _weatherDataList

    fun fetchWeatherData(city: String) {
        viewModelScope.launch {
            try {
                val response = weatherService.getCurrentWeather(city, apiKey)
                if (response.isSuccessful) {
                    val data = response.body()?.weatherDataList ?: emptyList()
                    _weatherDataList.value = data
                } else {
                    // Obrada greške ako nije uspio dohvatiti podatke
                }
            } catch (e: Exception) {
                // Obrada greške ako dođe do iznimke
            }
        }
    }
}
