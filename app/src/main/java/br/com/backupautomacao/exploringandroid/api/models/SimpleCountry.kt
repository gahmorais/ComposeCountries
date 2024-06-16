package br.com.backupautomacao.exploringandroid.api.models

data class SimpleCountry(
  override val flags: Flags,
  override val name: CountryName
) : Country
