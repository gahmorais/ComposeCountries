package br.com.backupautomacao.exploringandroid.di

import br.com.backupautomacao.exploringandroid.BuildConfig
import br.com.backupautomacao.exploringandroid.api.CountriesApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.gson.gson
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import timber.log.Timber

val mainModule = module {
  single { createHttpClient() }
  single { CountriesApi(get()) }
}

fun createHttpClient() = HttpClient(OkHttp) {
  engine {
    config {
      val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      }
      addInterceptor(logging)
    }
  }
  defaultRequest {
    Timber.i("API: ${BuildConfig.API_ADDRESS}")
    url(BuildConfig.API_ADDRESS)
  }
  install(HttpTimeout) {
    requestTimeoutMillis = 3000
  }
  install(ContentNegotiation) {
    gson()
  }
}