package br.com.backupautomacao.exploringandroid.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.backupautomacao.exploringandroid.R
import br.com.backupautomacao.exploringandroid.api.models.Country
import br.com.backupautomacao.exploringandroid.mock.countryMock
import coil.compose.AsyncImage
import timber.log.Timber

@Composable
fun CardFlag(
  modifier: Modifier = Modifier,
  onClick: (String) -> Unit = {},
  country: Country
) {
  Timber.i("Country: $country")
  Surface(
    modifier = modifier.clickable(
      onClick = { onClick(country.name.common) }
    )
  ) {
    Card(
      shape = RectangleShape,
      colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
      Column(
        verticalArrangement = Arrangement.Center
      ) {
        AsyncImage(
          modifier = Modifier
            .height(150.dp)
            .padding(bottom = 12.dp),
          model = country.flags.png,
          placeholder = painterResource(id = R.drawable.flag_placeholder),
          contentDescription = null
        )
        Text(
          modifier = Modifier.align(Alignment.CenterHorizontally),
          text = country.name.common,
          style = TextStyle(fontSize = 25.sp),
          textAlign = TextAlign.Center
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun CardFlagPreview() {
  CardFlag(country = countryMock)
}