package com.example.matheus.chamada.ui

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    val showLoading = ObservableBoolean(false)
    val handleError = ObservableField<Throwable>()
    val disposables = CompositeDisposable()

    fun addDisposable(d: Disposable) {
        disposables.add(d)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}