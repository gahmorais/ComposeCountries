package br.com.backupautomacao.exploringandroid.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.backupautomacao.exploringandroid.ui.theme.ExploringAndroidTheme
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ExploringAndroidTheme {
        KoinContext {
          MainScreen()
        }
      }
    }
  }
}
