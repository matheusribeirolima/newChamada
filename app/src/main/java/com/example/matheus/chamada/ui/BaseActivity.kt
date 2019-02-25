package com.example.matheus.chamada.ui

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(),
    HasSupportFragmentInjector {

    private val permissionsRequestCode = 0
    private lateinit var requestPermissionListener: RequestPermissionListener
    private lateinit var baseObserver: BaseObserver

    internal lateinit var binding: T
    internal lateinit var viewModel: V

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    interface RequestPermissionListener {
        fun onRequestCallback(granted: Boolean)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun initBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = getViewModel()

        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        baseObserver = BaseObserver(viewModel.showLoading, viewModel.handleError)
        baseObserver.observeChanges()

        initBinding()
    }

    fun getBinding(): T {
        return binding
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    fun isNetworkConnected(): Boolean {
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    fun requestPermission(
        permission: String,
        requestPermissionListener: RequestPermissionListener
    ) {
        this.requestPermissionListener = requestPermissionListener
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            requestPermissionListener.onRequestCallback(true)
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(permission),
                permissionsRequestCode
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            permissionsRequestCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestPermissionListener.onRequestCallback(true)
                } else {
                    requestPermissionListener.onRequestCallback(false)
                }
            }
        }
    }
}