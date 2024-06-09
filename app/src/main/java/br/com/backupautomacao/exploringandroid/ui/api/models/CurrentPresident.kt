package br.com.backupautomacao.exploringandroid.ui.api.models

import com.google.gson.annotations.SerializedName

data class CurrentPresident(
  @SerializedName("appointment_end_date")
  val appointmentEndDate: String,
  @SerializedName("appointment_start_date")
  val appointmentStartDate: String,
  val gender: String,
  val reference: ReferencePresident,
  val name: String
)