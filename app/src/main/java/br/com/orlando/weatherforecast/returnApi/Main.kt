package br.com.orlando.weatherforecast.returnApi

data class Main(val temp: Double = 0.0,
                val tempMin: Double = 0.0,
                val humidity: Int = 0,
                val pressure: Int = 0,
                val feelsLike: Double = 0.0,
                val tempMax: Int = 0)