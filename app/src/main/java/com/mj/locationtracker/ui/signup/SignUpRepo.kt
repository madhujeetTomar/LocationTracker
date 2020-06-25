package com.mj.locationtracker.ui.signup

import com.mj.locationtracker.base.ErrorResponse
import com.mj.locationtracker.base.ResponseListener
import com.mj.locationtracker.di.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SignUpRepo @Inject constructor(val apiService: ApiService) {
    fun signUp(listener: ResponseListener<String>,
               name: String, email: String, mobileNumber: String, password: String) {
apiService.signUp(name,email,mobileNumber,password).enqueue(object : Callback<String>
{
    override fun onFailure(call: Call<String>, t: Throwable) {


listener.onError(ErrorResponse(t.hashCode(),t.message!!))    }

    override fun onResponse(call: Call<String>, response: Response<String>) {
      listener.onSuccess(response.body()!!)
    }

})
    }
}
