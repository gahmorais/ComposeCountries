package br.com.backupautomacao.exploringandroid.ui.api.response

import br.com.backupautomacao.exploringandroid.ui.api.errors.ResponseError

data class ResultRequest<T>(
  val data: T?,
  val error: ResponseError? = null
)
