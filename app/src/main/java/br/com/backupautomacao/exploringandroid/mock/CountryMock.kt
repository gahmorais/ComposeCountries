package br.com.backupautomacao.exploringandroid.mock

import br.com.backupautomacao.exploringandroid.api.models.FullCountry
import com.google.gson.Gson

val countryJson = """
  {
    "flags": {
    "png": "https://flagcdn.com/w320/br.png",
    "svg": "https://flagcdn.com/br.svg",
    "alt": "The flag of Brazil has a green field with a large yellow rhombus in the center. Within the rhombus is a dark blue globe with twenty-seven small five-pointed white stars depicting a starry sky and a thin white convex horizontal band inscribed with the national motto 'Ordem e Progresso' across its center."
  },
    "name": {
    "common": "Brazil",
    "official": "Federative Republic of Brazil",
    "nativeName": {
    "por": {
    "official": "República Federativa do Brasil",
    "common": "Brasil"
  }
  }
  },
    "currencies": {
    "BRL": {
    "name": "Brazilian real",
    "symbol": "R${'$'}"
  }
  },
    "capital": [
    "Brasília"
    ],
    "altSpellings": [
    "BR",
    "Brasil",
    "Federative Republic of Brazil",
    "República Federativa do Brasil"
    ],
    "region": "Americas",
    "subregion": "South America",
    "languages": {
    "por": "Portuguese"
  },
    "maps": {
    "googleMaps": "https://goo.gl/maps/waCKk21HeeqFzkNC9",
    "openStreetMaps": "https://www.openstreetmap.org/relation/59470"
  },
    "population": 212559409
  }
""".trimIndent()

val countryMock: FullCountry = Gson().fromJson(countryJson, FullCountry::class.java)