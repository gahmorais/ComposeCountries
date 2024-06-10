package br.com.backupautomacao.exploringandroid.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
