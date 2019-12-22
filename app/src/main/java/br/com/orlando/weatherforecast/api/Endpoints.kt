package br.com.orlando.weatherforecast.api


import br.com.orlando.weatherforecast.returnApi.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoints {
    @GET("weather")
    fun getWeather(@Query("q") q:String, @Query("appid") appid:String): Call<WeatherResponse>



}