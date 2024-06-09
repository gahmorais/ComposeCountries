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

  suspend fun getCountries(): ResultRequest<List<Country>> {
    val response = httpClient.get("countries") {
      parameter("per_page", 10)
    }

    return when (response.status) {
      HttpStatusCode.OK -> {
        val responseBody = response.body<ResponseData<List<Country>>>()
        val countries = responseBody.data
        ResultRequest(countries)
      }
      else -> {
        val responseBody = response.body<ResponseData<List<Country>>>()
        val error = responseBody.error
        ResultRequest(data = null, error = error)
      }
    }
  }
}