package com.example.matheus.chamada.di.module

import com.example.matheus.chamada.ui.intro.activity.IntroActivity
import com.example.matheus.chamada.ui.main.activity.MainActivity
import com.example.matheus.chamada.ui.main.dimodule.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindIntroActivity(): IntroActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}