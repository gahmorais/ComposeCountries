package br.com.backupautomacao.exploringandroid.ui.api.models

data class ReferenceCountry(
  val self: String,
  val states: String,
  val presidents: String,
  val flag: String,
)

data class ReferencePresident(
  val self: String,
  val country: String,
  val picture: String
)