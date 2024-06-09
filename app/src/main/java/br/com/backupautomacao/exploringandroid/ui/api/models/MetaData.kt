package br.com.backupautomacao.exploringandroid.ui.api.models

import com.google.gson.annotations.SerializedName

data class MetaData(
  @SerializedName("current_page")
  val currentPage: Int,
  @SerializedName("last_page")
  val lastPage: Int,
  @SerializedName("per_page")
  val perPage: String,
  val from: Int,
  val path: String,
  val to: Int,
  val total: Int
)
