package hr.ferit.mvvm.model


data class WeatherModel(
    val temperature: Double,
    val weatherDescription: String,
    val weatherIconUrl: String // URL ikone vremena
)
