package br.com.backupautomacao.exploringandroid.ui.activities.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.backupautomacao.exploringandroid.R
import br.com.backupautomacao.exploringandroid.ui.screens.MainScreen
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryAppBar(
  modifier: Modifier = Modifier,
  currentScreen: CountryAppScreen,
  canNavigateBack: Boolean,
  navigateUp: () -> Unit,
) {
  TopAppBar(
    title = { Text(text = stringResource(id = currentScreen.title)) },
    colors = TopAppBarDefaults.mediumTopAppBarColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer
    ),
    modifier = modifier,
    navigationIcon = {
      if (canNavigateBack) {
        IconButton(onClick = navigateUp) {
          Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back_button)
          )
        }
      }
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryApp(navController: NavHostController = rememberNavController()) {

  val backStackEntry by navController.currentBackStackEntryAsState()
  val currentScreen = CountryAppScreen.valueOf(
    backStackEntry?.destination?.route ?: CountryAppScreen.MAIN.name
  )

  Scaffold(
    topBar = {
      CountryAppBar(
        currentScreen = currentScreen,
        canNavigateBack = navController.previousBackStackEntry != null,
        navigateUp = { navController.navigateUp() }
      )
    }
  ) { innerPadding ->
    NavHost(
      navController = navController,
      startDestination = CountryAppScreen.MAIN.name,
      modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)
    ) {
      composable(route = CountryAppScreen.MAIN.name) {
        MainScreen()
      }
      composable(route = CountryAppScreen.COUNTRY_DETAILS.name) {

      }
    }
  }

}