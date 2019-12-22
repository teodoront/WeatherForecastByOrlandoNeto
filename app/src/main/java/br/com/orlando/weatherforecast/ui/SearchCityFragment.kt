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
import kotlinx.android.synthetic.main.fragment_search_city.view.*

class SearchCityFragment : Fragment() {


    var appRepository = AppRepository()
    lateinit var prevResult : SearchCityViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_city, container, false)


    }

    override fun onResume() {
        super.onResume()

        prevResult = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)
        prevResult.getListWeather().observe(this, Observer {

            textResultado.text = it.coord.lon.toString()
            textResultLat.text = it.coord.lat.toString()
            textResultMax.text = it.main.tempMax.toString()
            textResultMim.text = it.main.tempMin.toString()
            textRerultCloud.text = it.clouds.all.toString()
            textResultWind.text = it.wind.speed.toString()
            textResultVisi.text = it.visibility.toString()
        })

        prevResult.getWheatherApi(inputNameCity.text.toString())

        btnSearch.setOnClickListener{

            it.textResultado
        }
    }

}