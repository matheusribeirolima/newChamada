package com.example.matheus.chamada.ui.intro.activity

import androidx.lifecycle.ViewModelProviders
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.ActivitySplashBinding
import com.example.matheus.chamada.ui.BaseActivity
import com.example.matheus.chamada.ui.intro.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun getBindingVariable(): Int {
        return BR.splashViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel {
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()

        viewModel.
    }
}
