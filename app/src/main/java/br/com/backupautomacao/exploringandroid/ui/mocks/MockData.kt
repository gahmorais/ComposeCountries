package br.com.backupautomacao.exploringandroid.ui.mocks

import br.com.backupautomacao.exploringandroid.ui.api.models.Country
import br.com.backupautomacao.exploringandroid.ui.api.models.Covid19
import br.com.backupautomacao.exploringandroid.ui.api.models.ReferenceCountry

val countryMock = Country(
  name = "Azerbaijan",
  fullname = "The Azerbaijan Democratic Republic",
  capital = "Baku",
  iso2 = "AZ",
  iso3 = "AZE",
  covid19 = Covid19(
    totalCase = "118,195",
    totalDeaths = "1,361",
    lastUpdated = "2020-12-01T08:35:42.000000Z"
  ),
  currentPresident = null,
  currency = "AZN",
  phoneCode = "994",
  continent = "Europe",
  description = null,
  size = "86,600 km²",
  population = "10,177,781",
  reference = ReferenceCountry(
    self = "https://restfulcountries.com/api/v1/countries/Azerbaijan",
    states = "https://restfulcountries.com/api/v1/countries/Azerbaijan/states",
    presidents = "https://restfulcountries.com/api/v1/countries/Azerbaijan/presidents",
    flag = "https://restfulcountries.com/assets/images/flags/Azerbaijan.png"
  )
)