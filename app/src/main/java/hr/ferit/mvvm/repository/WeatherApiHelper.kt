package hr.ferit.mvvm.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiHelper {

    val apiKey = "01fad58656f6068550af9a6540ebf121"

    private const val BASE_URL = "http://api.openweathermap.org/"

    fun createWeatherService(): WeatherService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(WeatherService::class.java)
    }
}
