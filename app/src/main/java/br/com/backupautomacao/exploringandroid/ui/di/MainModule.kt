package br.com.backupautomacao.exploringandroid.ui.di

import android.content.Context
import br.com.backupautomacao.exploringandroid.R
import br.com.backupautomacao.exploringandroid.ui.api.CountriesApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.gson.gson
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import timber.log.Timber

val mainModule = module {
  single {
    HttpClient(OkHttp) {
      engine {
        config {
          val logging = HttpLoggingInterceptor()
          logging.level = HttpLoggingInterceptor.Level.BODY
          addInterceptor(logging)
        }
      }
      defaultRequest {
        val apiAddress = "https://restfulcountries.com/api/v1/"
        val apiToken = get<Context>().getString(R.string.API_TOKEN)
        header("Accept","application/json")
        header("Authorization","Bearer $apiToken")
        url(apiAddress)
      }
      install(HttpTimeout) {
        requestTimeoutMillis = 3000
      }
      install(ContentNegotiation) {
        gson()
      }
    }
  }
  single { CountriesApi(get()) }
}