package com.mj.locationtracker

import android.app.Activity
import android.app.Application
import com.mj.locationtracker.di.AppComponent
import com.mj.locationtracker.di.DaggerAppComponent
import com.mj.locationtracker.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LocationTrackerApp :  Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent?.inject(this)

        DaggerAppComponent.builder().application(this).
        networkModuleapplication(NetworkModule("http://192.168.0.103/jagriti/"))
            .build().inject(this)


    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector     }

}
