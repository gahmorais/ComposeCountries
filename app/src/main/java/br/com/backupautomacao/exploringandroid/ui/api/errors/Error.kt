package br.com.backupautomacao.exploringandroid.ui.api.errors

import java.util.UUID

data class ResponseError(
  val id: String = UUID.randomUUID().toString(),
  val status: Int,
  val message: String
)
