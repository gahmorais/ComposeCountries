package br.com.backupautomacao.exploringandroid.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.backupautomacao.exploringandroid.ui.activities.main.MainViewModel
import br.com.backupautomacao.exploringandroid.ui.components.CardFlag
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
  viewModel: MainViewModel = koinViewModel(),
  modifier: Modifier = Modifier.fillMaxSize()
) {
  var searchedCountry by remember {
    mutableStateOf("")
  }
  val countries by viewModel.countries.collectAsState()
  Column(modifier = Modifier.fillMaxSize()) {
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      label = {
        Text(text = "Digite o nome do país")
      },
      value = searchedCountry,
      onValueChange = {
        searchedCountry = it
      }
    )
    if (countries.isNotEmpty()) {
      LazyVerticalGrid(
        columns = GridCells.Fixed(2),
      ) {
        items(countries) { country ->
          CardFlag(
            modifier = Modifier.padding(8.dp),
            country = country)
        }
      }
    }

  }
}