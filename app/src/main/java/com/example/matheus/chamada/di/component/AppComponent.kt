package com.example.matheus.chamada.di.component

import android.app.Application
import com.example.matheus.chamada.ChamadaApplication
import com.example.matheus.chamada.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        ImageLoaderModule::class,
        NetworkModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<ChamadaApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}