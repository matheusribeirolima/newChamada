package com.example.matheus.chamada.ui

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class BaseObserver constructor(
    private val showLoading: ObservableBoolean,
    private val handleError: ObservableField<Throwable>
) {

    fun observeChanges() {
        showLoading.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable, propertyId: Int) {
                if (showLoading.get()) {
                    showLoading()
                } else {
                    hideLoading()
                }
            }
        })

        handleError.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                handleError()
            }

        })
    }

    fun showLoading() {
//        LoadingDialog.getInstance().show(supportFragmentManager)
    }

    fun hideLoading() {
//        LoadingDialog.getInstance().dismiss()
    }

    fun handleError() {

    }
}