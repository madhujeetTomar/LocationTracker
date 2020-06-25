package com.mj.locationtracker.ui.signup

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.mj.locationtracker.base.BaseViewModel
import com.mj.locationtracker.base.ErrorResponse
import com.mj.locationtracker.base.ResponseListener

class SignUpViewModel  constructor(val signUpRepo: SignUpRepo) :
    BaseViewModel<SignUpNavigator>() {
    var responseLiveData: MutableLiveData<String> = MutableLiveData()
    var responseLiveDataError: MutableLiveData<String> = MutableLiveData()
    fun signUp(name: String, email: String, mobileNumber: String, password: String,
               confirmPassword: String) {

        signUpRepo.signUp(object : ResponseListener<String>{
            override fun onError(error: ErrorResponse) {
responseLiveDataError.postValue(error.getErrorMessage())
            }

            override fun onSuccess(response: String) {
          responseLiveData.postValue(response)
            }

        } ,name, email, mobileNumber, password)

    }

}