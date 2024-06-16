package br.com.backupautomacao.exploringandroid.api.models

data class FullCountry(
  override val flags: Flags,
  override val name: CountryName,
  val currencies: Map<String, Currencies>,
  val capital: List<String>,
  val altSpellings: List<String>,
  val region: String,
  val subregion: String,
  val languages: Map<String, String>,
  val maps: Maps,
  val population: Int
) : Country