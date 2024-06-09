package br.com.backupautomacao.exploringandroid.ui.api.response

import br.com.backupautomacao.exploringandroid.ui.api.errors.ResponseError
import br.com.backupautomacao.exploringandroid.ui.api.models.Links
import br.com.backupautomacao.exploringandroid.ui.api.models.MetaData
import com.google.gson.annotations.SerializedName

data class ResponseData<T>(
  @SerializedName("data")
  val data: T,
  val links: Links? = null,
  val meta: MetaData? = null,
  @SerializedName("error")
  val error: ResponseError? = null
)
