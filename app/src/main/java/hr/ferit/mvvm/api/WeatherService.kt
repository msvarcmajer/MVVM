package hr.ferit.mvvm.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response
import hr.ferit.mvvm.model.WeatherResponse

interface WeatherService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<WeatherResponse>
}
