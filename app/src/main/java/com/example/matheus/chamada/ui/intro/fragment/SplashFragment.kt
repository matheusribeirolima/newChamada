package com.example.matheus.chamada.ui.intro.fragment

import android.animation.Animator
import androidx.lifecycle.ViewModelProviders
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.matheus.chamada.BR
import com.example.matheus.chamada.R
import com.example.matheus.chamada.databinding.FragmentSplashBinding
import com.example.matheus.chamada.ui.BaseFragment
import com.example.matheus.chamada.ui.intro.viewmodel.IntroViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, IntroViewModel>() {

    companion object {
        const val TAG = "splash_fragment"

        @Synchronized
        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.introViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun getViewModel(): IntroViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(IntroViewModel::class.java)
        return viewModel
    }

    override fun initBinding() {
        binding = getBinding()

        animateLauncher()
    }

    private fun animateLauncher() {
        YoYo.with(Techniques.BounceIn)
            .duration(800)
            .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
            .withListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {

                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationRepeat(animation: Animator) {

                }
            })
            .playOn(binding.ivLauncherSplash)
    }
}