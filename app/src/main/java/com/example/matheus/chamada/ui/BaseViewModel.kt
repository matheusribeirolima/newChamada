package com.example.matheus.chamada.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var showLoading = ObservableBoolean(false)
}