package com.example.matheus.chamada.ui.base

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.DialogErrorBinding
import com.example.matheus.chamada.ui.BaseDialog
import com.example.matheus.chamada.ui.base.viewmodel.ErrorViewModel

class ErrorDialog : BaseDialog<DialogErrorBinding, ErrorViewModel>() {

    companion object {
        private const val TAG = "error_loading"

        @Synchronized
        fun newInstance(): ErrorDialog {
            return ErrorDialog()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.errorViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.dialog_error
    }

    override fun getDialogTag(): String {
        return TAG
    }

    override fun getViewModel(): ErrorViewModel {
        viewModel = ViewModelProviders.of(this).get(ErrorViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()

        viewModel.observableInt.observe(this,
            Observer<Int> { int -> binding.tvMessageError.text = resources.getText(int) })
    }

    fun handleThrowable(throwable: Throwable?) {
        throwable?.let { viewModel.handleThrowable(it) }
    }
}