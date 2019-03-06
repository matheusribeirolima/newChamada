package com.example.matheus.chamada.ui

import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentManager
import com.example.matheus.chamada.ui.base.ErrorDialog
import com.example.matheus.chamada.ui.base.LoadingDialog

class BaseObserver constructor(
    private val showLoading: ObservableBoolean,
    private val handleError: ObservableField<Throwable>,
    private val fragmentManager: FragmentManager?
) {

    private val loadingDialog = LoadingDialog.newInstance()
    private val errorDialog = ErrorDialog.newInstance()

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
        fragmentManager?.let { loadingDialog.show(it) }
    }

    fun hideLoading() {
        loadingDialog.dismiss()
    }

    fun handleError() {
        fragmentManager?.let {
            errorDialog.handleThrowable(handleError.get())
            errorDialog.show(it)
        }
    }
}