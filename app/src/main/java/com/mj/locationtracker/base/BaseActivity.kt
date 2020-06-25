package com.mj.locationtracker.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.mj.locationtracker.helperr.ProgressDialogHelper
import dagger.android.AndroidInjection

import kotlin.text.Typography.dagger

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity() {

    var mViewDataBinding: T? = null

    var mViewModel: V? = null

    protected lateinit var progressDialogHelper: ProgressDialogHelper


    @LayoutRes
   abstract fun getLayoutResId():Int

    abstract fun getBindingVariable(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
        progressDialogHelper = ProgressDialogHelper(this)
        //   configureToolbar()

    }


    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.setLifecycleOwner(this)
        mViewDataBinding?.executePendingBindings()
    }
}