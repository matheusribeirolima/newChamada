package com.example.matheus.chamada.di.component

import android.app.Application
import com.example.matheus.chamada.ChamadaApplication
import com.example.matheus.chamada.di.module.ActivityModule
import com.example.matheus.chamada.di.module.AppModule
import com.example.matheus.chamada.di.module.ImageLoaderModule
import com.example.matheus.chamada.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ImageLoaderModule::class]
)
interface AppComponent : AndroidInjector<ChamadaApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}