package br.com.backupautomacao.exploringandroid.di

import br.com.backupautomacao.exploringandroid.ui.activities.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { MainViewModel(get()) }
}