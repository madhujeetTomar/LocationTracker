package com.mj.locationtracker



import com.mj.locationtracker.ui.signup.SignUp
import com.mj.locationtracker.ui.signup.SignUpModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBinder {


    @ContributesAndroidInjector(modules = arrayOf(SignUpModule::class))
    abstract fun bindingOrderActivity(): SignUp

}
