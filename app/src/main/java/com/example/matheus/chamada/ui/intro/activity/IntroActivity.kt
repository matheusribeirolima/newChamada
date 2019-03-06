package com.example.matheus.chamada.ui.intro.activity

import androidx.lifecycle.ViewModelProviders
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.ActivityIntroBinding
import com.example.matheus.chamada.ui.BaseActivity
import com.example.matheus.chamada.ui.intro.viewmodel.IntroViewModel

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>() {

    override fun getBindingVariable(): Int {
        return BR.introViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_intro
    }

    override fun getViewModel(): IntroViewModel {
        viewModel = ViewModelProviders.of(this).get(IntroViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()


    }
}
