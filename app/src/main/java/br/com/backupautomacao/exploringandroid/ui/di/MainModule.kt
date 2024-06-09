package br.com.backupautomacao.exploringandroid.ui.di

import br.com.backupautomacao.exploringandroid.ui.api.CountriesApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.gson.gson
import org.koin.dsl.module

val mainModule = module {
  single {
    HttpClient {
      defaultRequest {
        val apiAddress = System.getenv("API_ADDRESS")
        apiAddress?.let { url(it) }
      }
      install(HttpTimeout) {
        requestTimeoutMillis = 3000
      }
      install(ContentNegotiation) {
        gson()
      }
      install(Auth) {
        bearer {
          System.getenv("API_TOKEN")?.let { token ->
            BearerTokens(token, "")
          }
        }
      }
    }
  }
  single { CountriesApi(get()) }
}