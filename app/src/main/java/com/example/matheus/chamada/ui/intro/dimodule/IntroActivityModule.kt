package com.example.matheus.chamada.ui.intro.dimodule

import com.example.matheus.chamada.ui.intro.fragment.LoginFingerprintFragment
import com.example.matheus.chamada.ui.intro.fragment.LoginFragment
import com.example.matheus.chamada.ui.intro.fragment.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class IntroActivityModule {

    @ContributesAndroidInjector
    abstract fun bindSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun bindLoginFingerprintFragment(): LoginFingerprintFragment
}