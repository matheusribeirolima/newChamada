package com.example.matheus.chamada.ui.base.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.matheus.chamada.R
import com.example.matheus.chamada.data.model.service.SessionExpired
import com.example.matheus.chamada.ui.BaseViewModel
import javax.inject.Inject

class ErrorViewModel @Inject constructor() : BaseViewModel() {

    val observableInt = MutableLiveData<Int>()

    fun handleThrowable(throwable: Throwable) {
        if (throwable is SessionExpired) {
            observableInt.value = R.string.ssession_error
        } else {
            observableInt.value = R.string.unexpected_error
        }
    }
}