package com.example.matheus.chamada.ui.intro.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.matheus.chamada.data.model.User
import com.example.matheus.chamada.data.source.ChamadaRepository
import com.example.matheus.chamada.ui.BaseViewModel
import javax.inject.Inject

class IntroViewModel @Inject constructor(private val repository: ChamadaRepository) : BaseViewModel() {

    val response = MutableLiveData<User>()
    private val login = ObservableField<String>("")
    private val password = ObservableField<String>("")

    fun doLogin() {
        addDisposable(repository.doLogin(login.get(), password.get())
            .doOnSubscribe { showLoading.set(true) }
            .doOnSuccess { showLoading.set(false) }
            .subscribe(
                { success -> response.value = success },
                { error -> handleError.set(error)})
        )
    }

}