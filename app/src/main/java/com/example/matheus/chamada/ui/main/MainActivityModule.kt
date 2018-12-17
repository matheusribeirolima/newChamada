package com.example.matheus.chamada.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.matheus.chamada.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideActivity(): AppCompatActivity {
        return MainActivity()
    }

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager
    }

//    @ContributesAndroidInjector
//    abstract fun selectAgencyAndAccountFragment(): SelectAgencyAndAccountFragment

}