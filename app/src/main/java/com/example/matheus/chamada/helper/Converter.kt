package com.example.matheus.chamada.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import io.reactivex.*

class Converter {

    fun <T> Flowable<T>.toLiveData(): LiveData<T> {
        return LiveDataReactiveStreams.fromPublisher(this)
    }

    fun <T> Observable<T>.toLiveData(backPressureStrategy: BackpressureStrategy): LiveData<T> {
        return LiveDataReactiveStreams.fromPublisher(this.toFlowable(backPressureStrategy))
    }

    fun <T> Single<T>.toLiveData(): LiveData<T> {
        return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
    }

    fun <T> Maybe<T>.toLiveData(): LiveData<T> {
        return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
    }

    fun <T> Completable.toLiveData(): LiveData<T> {
        return LiveDataReactiveStreams.fromPublisher(this.toFlowable())
    }
}