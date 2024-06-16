package br.com.backupautomacao.exploringandroid.ui.activities.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.backupautomacao.exploringandroid.R
import br.com.backupautomacao.exploringandroid.ui.api.models.Country
import br.com.backupautomacao.exploringandroid.ui.mocks.countryMock
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountryCard(
  country: Country,
  onClick: () -> Unit = {}
) {
  Surface(modifier = Modifier.height(130.dp)) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .combinedClickable(onClick = onClick),
      elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
          modifier = Modifier.size(120.dp),
          model = country.reference.flag,
          placeholder = painterResource(id = R.drawable.flag_placeholder),
          contentDescription = "Country Flag"
        )
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp),
          verticalArrangement = Arrangement
            .spacedBy(5.dp, Alignment.CenterVertically)
        ) {
          Text(
            text = country.name,
            style = TextStyle(fontSize = 20.sp)
          )
          Text(text = country.fullname, style = TextStyle(fontSize = 15.sp))
          Text(text = country.capital, style = TextStyle(fontSize = 15.sp))
          Text(text = country.population.replace(",", "."), style = TextStyle(fontSize = 15.sp))
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CountryCardPreview() {
  CountryCard(country = countryMock)
}