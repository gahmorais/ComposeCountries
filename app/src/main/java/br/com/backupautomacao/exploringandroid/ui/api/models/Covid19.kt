package br.com.backupautomacao.exploringandroid.ui.api.models

import com.google.gson.annotations.SerializedName

data class Covid19(
  @SerializedName("last_updated")
  val lastUpdated: String,
  @SerializedName("total_case")
  val totalCase: String,
  @SerializedName("total_deaths")
  val totalDeaths: String
)