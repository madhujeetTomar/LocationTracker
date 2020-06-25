package com.mj.locationtracker.ui.signup

import com.mj.locationtracker.di.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class SignUpModule {

    @Provides
    fun providesOrderViewModel(signUpRepo: SignUpRepo): SignUpViewModel {
        return SignUpViewModel(signUpRepo)
    }

    @Provides
    open fun providesOrderApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesOrderRepo(
      orderApiService: ApiService
    ): SignUpRepo {
        return SignUpRepo(
            orderApiService
        )
    }
}