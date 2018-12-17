package com.example.matheus.chamada

import android.os.Build
import android.view.autofill.AutofillManager
import com.example.matheus.chamada.di.component.DaggerAppComponent
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.orhanobut.hawk.Hawk
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class ChamadaApplication : DaggerApplication() {

    @Inject
    lateinit var config: ImageLoaderConfiguration

    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()

        ImageLoader.getInstance().init(config)

        configureAutoFill()
    }

    override fun applicationInjector(): AndroidInjector<ChamadaApplication> {
        val appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }

    private fun configureAutoFill() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getSystemService(AutofillManager::class.java)?.disableAutofillServices()
        }
    }
}