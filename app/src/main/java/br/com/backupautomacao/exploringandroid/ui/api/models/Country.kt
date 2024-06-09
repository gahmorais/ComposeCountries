package br.com.backupautomacao.exploringandroid.ui.api.models

import com.google.gson.annotations.SerializedName

data class Country(
  val name: String,
  @SerializedName("full_name")
  val fullname: String,
  val capital: String,
  val iso2: String,
  val iso3: String,
  val covid19: Covid19,
  @SerializedName("current_president")
  val currentPresident: CurrentPresident,
  val currency: String,
  @SerializedName("phone_code")
  val phoneCode: String,
  val continent: String,
  val description: String,
  val size: String,
  val population: String,
  @SerializedName("href")
  val reference: ReferenceCountry
)