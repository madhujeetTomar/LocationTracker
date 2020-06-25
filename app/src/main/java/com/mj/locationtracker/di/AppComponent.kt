package com.mj.locationtracker.di

import android.app.Application
import com.mj.locationtracker.ActivityBinder
import com.mj.locationtracker.LocationTrackerApp

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class,
        NetworkModule::class, ActivityBinder::class]
)
interface AppComponent {

    fun inject(app: LocationTrackerApp )

    fun inject(networkModule: NetworkModule)

    @Component.Builder
    interface Builder {

@BindsInstance
        fun application(application: Application): Builder

        fun networkModuleapplication(networkModule: NetworkModule): Builder

        fun build(): AppComponent

    }




}