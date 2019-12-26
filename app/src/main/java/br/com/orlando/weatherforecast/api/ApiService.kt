package br.com.orlando.weatherforecast.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndpoints(): Endpoints {
        return getRetrofit().create(Endpoints::class.java)
    }
}