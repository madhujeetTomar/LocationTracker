package com.mj.locationtracker.base

import com.mj.locationtracker.base.ErrorResponse

interface ResponseListener<T> {

    fun onError(error: ErrorResponse)
    fun onSuccess(response: T)
}