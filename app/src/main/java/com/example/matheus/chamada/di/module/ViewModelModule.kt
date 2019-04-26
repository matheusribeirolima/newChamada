package com.example.matheus.chamada.di.module

import dagger.Module
import androidx.lifecycle.ViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import androidx.lifecycle.ViewModelProvider
import com.example.matheus.chamada.di.ViewModelKey
import com.example.matheus.chamada.ui.base.ViewModelFactory
import com.example.matheus.chamada.ui.base.viewmodel.ErrorViewModel
import com.example.matheus.chamada.ui.intro.viewmodel.IntroViewModel
import com.example.matheus.chamada.ui.main.viewmodel.MainViewModel

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ErrorViewModel::class)
    internal abstract fun bindErrorViewModel(errorViewModel: ErrorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(IntroViewModel::class)
    internal abstract fun bindIntroViewModel(introViewModel: IntroViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}