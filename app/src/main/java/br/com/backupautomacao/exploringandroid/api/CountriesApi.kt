package br.com.backupautomacao.exploringandroid.api

import br.com.backupautomacao.exploringandroid.api.response.errors.ResponseError
import br.com.backupautomacao.exploringandroid.api.models.FullCountry
import br.com.backupautomacao.exploringandroid.api.models.SimpleCountry
import br.com.backupautomacao.exploringandroid.api.response.ResultRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode

class CountriesApi(private val httpClient: HttpClient) {
  private val countryFields =
    "name,flags,currencies,region,subregion,capital,altSpellings,languages,maps,population"
  private val simpleFields = "name,flags"
  suspend fun getCountryByName(name: String): ResultRequest<FullCountry> {
    val response = httpClient.get("name/$name") {
      parameter("fullText", "true")
      parameter("fields", countryFields)
    }
    return when (response.status) {
      HttpStatusCode.OK -> {
        val country = response.body<List<FullCountry>>()
        ResultRequest(data = country[0])
      }

      else -> {
        val error = response.body<ResponseError>()
        ResultRequest(data = null, error)
      }
    }
  }

  suspend fun getAllCountries(): ResultRequest<List<SimpleCountry>> {
    val response = httpClient.get("all") {
      parameter("fields", simpleFields)
    }

    return when (response.status) {
      HttpStatusCode.OK -> {
        val countries = response.body<List<SimpleCountry>>()
        ResultRequest(countries)
      }

      else -> {
        val error = response.body<ResponseError>()
        ResultRequest(data = null, error = error)
      }
    }
  }
}