package br.com.orlando.weatherforecast.repository

import android.R
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import br.com.orlando.weatherforecast.api.ApiService
import br.com.orlando.weatherforecast.returnApi.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AppRepository() {

    var listWeather = MutableLiveData<WeatherResponse>()

    fun getWheather(nameCity: String, context: Context?) {

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

                if (response.code() == 200) {
                    listWeather.value = response.body()

                } else {
                    Toast.makeText(context, "Enter valid name city", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}