package com.example.movierating

import android.app.Application
import com.example.movierating.di.AppComponent
import com.example.movierating.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initAppComponent()
    }

    fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appContext(this)
            .build()
    }
}