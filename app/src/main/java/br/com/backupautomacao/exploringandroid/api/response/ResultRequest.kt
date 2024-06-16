package br.com.backupautomacao.exploringandroid.api.response

import br.com.backupautomacao.exploringandroid.api.response.errors.ResponseError

data class ResultRequest<T>(
  val data: T?,
  val error: ResponseError? = null
)
