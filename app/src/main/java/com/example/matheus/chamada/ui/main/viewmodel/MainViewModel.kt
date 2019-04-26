package com.example.matheus.chamada.ui.main.viewmodel

import com.example.matheus.chamada.ui.BaseViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    fun getBottomListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            //listener.onItemSelected(item)
            true
        }
    }
}