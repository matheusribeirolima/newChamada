package com.example.matheus.chamada.di.module

import android.content.Context
import com.example.matheus.chamada.di.ApplicationContext
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Provides
    @Singleton
    fun provideFadeInBitmapDisplayer(): FadeInBitmapDisplayer {
        return FadeInBitmapDisplayer(600)
    }

    @Provides
    @Singleton
    fun provideDisplayImageOptions(fadeInBitmapDisplayer: FadeInBitmapDisplayer): DisplayImageOptions {
        return DisplayImageOptions
            .Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .displayer(fadeInBitmapDisplayer)
            .build()
    }

    @Provides
    @Singleton
    fun provideBaseImageDecoder(): BaseImageDecoder {
        return BaseImageDecoder(true)
    }

    @Provides
    @Singleton
    fun provideWeakMemoryCache(): WeakMemoryCache {
        return WeakMemoryCache()
    }

    @Provides
    @Singleton
    fun provideImageLoaderConfiguration(
        displayImageOptions: DisplayImageOptions,
        baseImageDecoder: BaseImageDecoder,
        weakMemoryCache: WeakMemoryCache,
        @ApplicationContext context: Context
    ): ImageLoaderConfiguration {
        return ImageLoaderConfiguration
            .Builder(context)
            .defaultDisplayImageOptions(displayImageOptions)
            .imageDecoder(baseImageDecoder)
            .memoryCache(weakMemoryCache)
            .build()
    }
}