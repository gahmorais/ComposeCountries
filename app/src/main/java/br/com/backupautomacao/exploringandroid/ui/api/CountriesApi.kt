package br.com.backupautomacao.exploringandroid.ui.api

import br.com.backupautomacao.exploringandroid.ui.api.models.Country
import br.com.backupautomacao.exploringandroid.ui.api.response.ResponseData
import br.com.backupautomacao.exploringandroid.ui.api.response.ResultRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode

class CountriesApi(private val httpClient: HttpClient) {

  suspend fun getCountries(page: Int = 1, perPage: Int = 10): ResultRequest<List<Country>> {
    val response = httpClient.get("countries") {
      parameter("per_page", perPage)
      parameter("page", page)
    }
    val responseBody = response.body<ResponseData<List<Country>>>()

    return when (response.status) {
      HttpStatusCode.OK -> {
        val countries = responseBody.data
        ResultRequest(countries)
      }

      else -> {
        val error = responseBody.error
        ResultRequest(data = null, error = error)
      }
    }
  }

  suspend fun getCountriesByName(name: String): ResultRequest<Country> {
    val response = httpClient.get("countries/$name")
    val responseBody = response.body<ResponseData<Country>>()
    return when (response.status) {
      HttpStatusCode.OK -> {
        val country = responseBody.data
        ResultRequest(data = country)
      }

      else -> {
        val error = responseBody.error
        ResultRequest(data = null, error = error)
      }
    }
  }

  suspend fun getCountriesByContinent(name: String): ResultRequest<List<Country>> {
    val response = httpClient.get("countries") {
      parameter("continent", name)
    }
    val responseBody = response.body<ResponseData<List<Country>>>()
    return when (response.status) {
      HttpStatusCode.OK -> {
        val countries = responseBody.data
        ResultRequest(data = countries)
      }

      else -> {
        val error = responseBody.error
        ResultRequest(data = null, error = error)
      }
    }
  }
}