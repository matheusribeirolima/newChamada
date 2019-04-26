package com.example.matheus.chamada.ui.intro.fragment

import androidx.lifecycle.ViewModelProviders
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.FragmentLoginFingerprintBinding
import com.example.matheus.chamada.ui.BaseFragment
import com.example.matheus.chamada.ui.intro.viewmodel.IntroViewModel

class LoginFingerprintFragment : BaseFragment<FragmentLoginFingerprintBinding, IntroViewModel>() {

    override fun getBindingVariable(): Int {
        return BR.introViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login_fingerprint
    }

    override fun getViewModel(): IntroViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(IntroViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()
    }
}