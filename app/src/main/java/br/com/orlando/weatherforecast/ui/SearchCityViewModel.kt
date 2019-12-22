package br.com.orlando.weatherforecast.ui

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import br.com.orlando.weatherforecast.repository.AppRepository

class SearchCityViewModel (application: Application): AndroidViewModel(application) {

     private var repository = AppRepository()

    fun getListWeather()= repository.listWeather
    fun getWheatherApi(namecity: String) = repository.getWheather(namecity)
}

