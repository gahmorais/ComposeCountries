package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.backupautomacao.exploringandroid.ui.activities.main.components.CountryList
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
  var countrySearch by remember {
    mutableStateOf("")
  }
  val countries by viewModel.countries.collectAsState()
  // A surface container using the 'background' color from the theme
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Column {
      OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), label = {
        Text(text = "Type Country Name")
      }, trailingIcon = {
        IconButton(onClick = {
          viewModel.getCountryByName(countrySearch)
        }) {
          Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }
      }, value = countrySearch, onValueChange = {
        countrySearch = it
      })
      CountryList(countries = countries)

    }
  }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
  MainScreen()
}