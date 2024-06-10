package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.backupautomacao.exploringandroid.ui.api.CountriesApi
import br.com.backupautomacao.exploringandroid.ui.api.errors.ResponseError
import br.com.backupautomacao.exploringandroid.ui.api.models.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val countriesApi: CountriesApi) : ViewModel() {

  private val _countries = MutableStateFlow<List<Country>>(listOf())
  val countries = _countries.asStateFlow()

  private val _error = MutableStateFlow<ResponseError?>(null)
  val error = _error.asStateFlow()

  suspend fun getCountries() {
    val countries = countriesApi.getCountriesByContinent("asia")
    Timber.tag("MainViewModel").i("Countries: $countries")
  }

  fun getCountryByName(name: String) {
    viewModelScope.launch(Dispatchers.IO) {
      val result = countriesApi.getCountriesByName(name)
      if (result.data != null) {
        val country = result.data
        _countries.update { listOf(country) }
      } else {
        val responseError = result.error
        _error.update { responseError }
      }
    }
  }
}