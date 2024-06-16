package br.com.backupautomacao.exploringandroid.api.models

data class CountryName(
  val common: String,
  val official: String,
  val nativeName: Map<String, NativeName>
)
