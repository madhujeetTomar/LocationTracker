package com.mj.locationtracker.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule {
    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application
    }


}