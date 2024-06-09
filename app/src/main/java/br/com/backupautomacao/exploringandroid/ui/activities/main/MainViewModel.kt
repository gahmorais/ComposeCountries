package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.lifecycle.ViewModel
import br.com.backupautomacao.exploringandroid.ui.api.CountriesApi

class MainViewModel(private val countriesApi: CountriesApi) : ViewModel() {
  suspend fun getCountries(){
    val countries = countriesApi.getCountries()

  }
}