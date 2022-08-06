package com.pet.finder.app.app

import android.app.Application
import com.pet.finder.app.di.AppComponent
import com.pet.finder.app.di.AppModule
import com.pet.finder.app.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}