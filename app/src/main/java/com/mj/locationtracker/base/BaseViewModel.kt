package com.mj.locationtracker.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>: ViewModel() {

open var mNavigator: WeakReference<N>? = null
    open val isSomeErrorOccured = ObservableBoolean(false)

    open val isLoading = ObservableBoolean(false)


    override fun onCleared() {
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }



    var navigator: N
        get() = mNavigator?.get()!!
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }
}