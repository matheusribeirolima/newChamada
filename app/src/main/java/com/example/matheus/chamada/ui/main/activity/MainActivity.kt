package com.example.matheus.chamada.ui.main.activity

import androidx.lifecycle.ViewModelProviders
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.ActivityMainBinding
import com.example.matheus.chamada.ui.BaseActivity
import com.example.matheus.chamada.ui.main.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()
    }

}
