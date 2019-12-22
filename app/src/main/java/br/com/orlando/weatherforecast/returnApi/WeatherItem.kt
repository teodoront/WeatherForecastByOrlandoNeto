package br.com.orlando.weatherforecast.returnApi

data class WeatherItem(val icon: String = "",
                       val description: String = "",
                       val main: String = "",
                       val id: Int = 0)