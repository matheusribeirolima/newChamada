package com.example.matheus.chamada.di.module

import android.app.Application
import android.content.Context
import com.example.matheus.chamada.di.ApplicationContext
import com.example.matheus.chamada.util.ResourceManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    @ApplicationContext
    abstract fun bindContext(chamadaApplication: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideResourceManager(@ApplicationContext context: Context): ResourceManager {
            return ResourceManager(context)
        }
    }
}
