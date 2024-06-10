package br.com.backupautomacao.exploringandroid.ui

import android.app.Application
import br.com.backupautomacao.exploringandroid.ui.di.mainModule
import br.com.backupautomacao.exploringandroid.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class CoreApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    Timber.plant(Timber.DebugTree())
    startKoin {
      androidContext(this@CoreApplication)
      androidLogger(Level.DEBUG)
      modules(mainModule, viewModelModule)
    }
  }
}