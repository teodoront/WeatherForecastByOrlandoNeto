package br.com.orlando.weatherforecast.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.orlando.weatherforecast.api.ApiService
import br.com.orlando.weatherforecast.returnApi.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepository() {

    var listWeather = MutableLiveData<WeatherResponse>()

    fun getWheather(nameCity: String) {

        val request =
            ApiService.getEndpoints().getWeather(nameCity, "b6907d289e10d714a6e88b30761fae22")
        request.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                Log.i("Erro", "Deu ruim!!!!")
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {

                listWeather.value = response.body()
            }
        })
    }

}