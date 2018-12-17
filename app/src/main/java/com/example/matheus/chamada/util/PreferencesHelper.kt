package com.example.matheus.chamada.util

import com.orhanobut.hawk.Hawk

object PreferencesHelper {

    @JvmStatic
    val ACCESS_TOKEN = "sp_access_token"
    @JvmStatic
    val FINGERPRINT_CHECKED = "sp_fingerprint_checked"
    @JvmStatic
    val FINGERPRINT_LOGIN_USER = "sp_fingerprint_login_user"

    fun logout() {
        val fingerprint = Hawk.get(FINGERPRINT_CHECKED, false)
        val login = Hawk.get(FINGERPRINT_LOGIN_USER, "")
        val password = Hawk.get<String>(login)

        Hawk.deleteAll()
        Hawk.put(FINGERPRINT_CHECKED, fingerprint)
        Hawk.put(FINGERPRINT_LOGIN_USER, login)
        Hawk.put(login, password)
    }
}