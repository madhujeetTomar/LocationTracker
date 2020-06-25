package com.mj.locationtracker.ui.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mj.locationtracker.BR
import com.mj.locationtracker.R
import com.mj.locationtracker.base.BaseActivity
import com.mj.locationtracker.databinding.ActivitySignUpBinding
import javax.inject.Inject

class SignUp : BaseActivity<ActivitySignUpBinding, SignUpViewModel>(){

    @Inject
    lateinit var signUpViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

mViewDataBinding?.button?.setOnClickListener {

        signUpViewModel.signUp(mViewDataBinding?.etName?.text.toString(),
            mViewDataBinding?.etEmail?.text.toString(),
            mViewDataBinding?.etMobileNumber?.text.toString(),
            mViewDataBinding?.etPassword?.text.toString(),
            mViewDataBinding?.etConfirmPassword?.text.toString())

}

        val name = Observer<String> { s -> updateData(s) }
        signUpViewModel.responseLiveData.observe(this, name)

        val error = Observer<String> { s -> errorData(s) }
        signUpViewModel.responseLiveDataError.observe(this, error)

    }

    private fun errorData(s: String?) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show()
    }

    private fun updateData(s: String?) {
Toast.makeText(this,s,Toast.LENGTH_LONG).show()
    }

    override fun getLayoutResId(): Int {
      return R.layout.activity_sign_up
    }

    override fun getBindingVariable(): Int {
       return BR.model
    }

    override fun getViewModel(): SignUpViewModel {
        return signUpViewModel
          }
}
