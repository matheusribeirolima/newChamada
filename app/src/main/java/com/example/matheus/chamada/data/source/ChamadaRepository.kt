package com.example.matheus.chamada.data.source

import com.example.matheus.chamada.data.model.User
import com.example.matheus.chamada.data.model.service.login.LoginRequest
import com.example.matheus.chamada.data.model.service.login.LoginResponse
import com.example.matheus.chamada.helper.PreferencesHelper
import com.orhanobut.hawk.Hawk
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChamadaRepository @Inject constructor(private val api: ChamadaApi) {

    fun doLogin(login: String?, password: String?): Single<User?> {
        return api.login(LoginRequest(login, password))
            .map {
                Hawk.put(PreferencesHelper.ACCESS_TOKEN, it.accessToken)
                return@map it.user
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}