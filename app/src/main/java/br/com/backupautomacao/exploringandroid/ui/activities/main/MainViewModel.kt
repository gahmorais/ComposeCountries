package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.backupautomacao.exploringandroid.api.CountriesApi
import br.com.backupautomacao.exploringandroid.api.response.errors.ResponseError
import br.com.backupautomacao.exploringandroid.api.models.Country
import br.com.backupautomacao.exploringandroid.api.models.FullCountry
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val countriesApi: CountriesApi) : ViewModel() {

  init {
    viewModelScope.launch { getAllCountries() }
  }

  private val _countries = MutableStateFlow<List<Country>>(listOf())
  val countries = _countries.asStateFlow()

  private val _error = MutableSharedFlow<ResponseError?>()
  val error = _error.asSharedFlow()

  suspend fun getAllCountries() {
    val result = countriesApi.getAllCountries()
    if (result.data != null) {
      val countries = result.data
      _countries.emit(countries)
    } else {
      val error = result.error
      _error.emit(error)
    }
  }
}