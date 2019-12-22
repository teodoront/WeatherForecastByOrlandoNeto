package br.com.orlando.weatherforecast.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.orlando.weatherforecast.R
import br.com.orlando.weatherforecast.repository.AppRepository
import kotlinx.android.synthetic.main.fragment_search_city.*

import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResult : Fragment() {
    var appRepository = AppRepository()
    lateinit var prevResult : SearchCityViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result,container,false)
    }


    override fun onResume() {
        super.onResume()

        prevResult = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)
        prevResult.getListWeather().observe(this, Observer {

            textResult.text = it.name
        })

        prevResult.getWheatherApi(inputNameCity.text.toString())

        // textResult.
    }
}