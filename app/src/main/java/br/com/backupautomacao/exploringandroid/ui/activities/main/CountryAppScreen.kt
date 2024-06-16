package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.annotation.StringRes
import br.com.backupautomacao.exploringandroid.R

enum class CountryAppScreen(@StringRes val title: Int) {
  MAIN(title = R.string.main),
  COUNTRY_DETAILS(title = R.string.country_details)
}