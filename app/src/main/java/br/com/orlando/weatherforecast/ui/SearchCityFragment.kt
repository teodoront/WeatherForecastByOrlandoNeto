package br.com.orlando.weatherforecast.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.orlando.weatherforecast.R
import br.com.orlando.weatherforecast.repository.AppRepository
import br.com.orlando.weatherforecast.returnApi.Clouds
import br.com.orlando.weatherforecast.returnApi.Coord
import br.com.orlando.weatherforecast.returnApi.Main
import br.com.orlando.weatherforecast.returnApi.WeatherResponse
import kotlinx.android.synthetic.main.fragment_search_city.*
import kotlinx.android.synthetic.main.fragment_search_city.view.*


class SearchCityFragment : Fragment() {


    lateinit var prevResult: SearchCityViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_search_city, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId;

        when (item.itemId) {

            R.id.settings_action -> {
                findNavController().navigate(R.id.action_searchCityFragment_to_searchResult)
            }

        }

        return super.onOptionsItemSelected(item)


    }

    override fun onResume() {
        super.onResume()


        prevResult = ViewModelProviders.of(this).get(SearchCityViewModel::class.java)

        btnSearch.setOnClickListener {
            prevResult.getListWeather().observe(this, Observer {

                textResultado.text = it.coord.lon.toString()
                textResultLat.text = it.coord.lat.toString()
                textResultHum.text = it.main.humidity.toString()
                textResultTemp.text = it.main.temp.toString()
                textRerultCloud.text = it.clouds.all.toString()
                textResultWind.text = it.wind.speed.toString()
                textResultVisi.text = it.visibility.toString()
                textCountRes.text = it.sys.country
            })

            prevResult.getWheatherApi(inputNameCity.text.toString(), context)


        }

        if (inputNameCity != null) {
            prevResult.getListWeather().observe(this, Observer {

                textResultado.text = it.coord.lon.toString()
                textResultLat.text = it.coord.lat.toString()
                textResultHum.text = it.main.humidity.toString()
                textResultTemp.text = it.main.temp.toString()
                textRerultCloud.text = it.clouds.all.toString()
                textResultWind.text = it.wind.speed.toString()
                textResultVisi.text = it.visibility.toString()
                textCountRes.text = it.sys.country
            })

            prevResult.getWheatherApi(inputNameCity.text.toString(), context)

        }
    }

}