package com.example.matheus.chamada.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseDialog<T : ViewDataBinding, V : BaseViewModel> : DialogFragment(), HasSupportFragmentInjector {

    private lateinit var baseActivity: BaseActivity<T, V>
    private lateinit var baseObserver: BaseObserver

    internal lateinit var binding: T
    internal lateinit var viewModel: V

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun initBinding()

    fun getBinding(): T {
        return binding
    }

    fun getBaseActivity(): BaseActivity<T, V> {
        return baseActivity
    }

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()

        baseObserver = BaseObserver(viewModel.showLoading, viewModel.handleError)
        baseObserver.observeChanges()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        initBinding()
    }

    fun hideKeyboard() {
        baseActivity.hideKeyboard()
    }

    fun isNetworkConnected(): Boolean {
        return baseActivity.isNetworkConnected()
    }

    fun showOnce(fragmentManager: FragmentManager, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        fragmentManager.findFragmentByTag(tag)?.let { transaction.remove(it) }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }
}