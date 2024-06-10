package br.com.backupautomacao.exploringandroid.ui.activities.main.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.backupautomacao.exploringandroid.ui.api.models.Country
import br.com.backupautomacao.exploringandroid.ui.mocks.countryMock

@Composable
fun CountryList(countries: List<Country>) {
  LazyColumn {
    items(countries) {
      CountryCard(country = it)
    }
  }
}

@Composable
@Preview(showBackground = true)
fun CountryListPreview() {
  CountryList(countries = listOf(countryMock, countryMock))
}