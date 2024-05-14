package hr.ferit.mvvm.repository



import hr.ferit.mvvm.model.WeatherModel
import retrofit2.http.GET

interface WeatherService {

    @GET("data/2.5/weather?q=Osijek&appid=01fad58656f6068550af9a6540ebf121&units=metric")
    suspend fun getWeather(): WeatherModel
}