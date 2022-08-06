package com.pet.finder.app.di

import com.pet.finder.app.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}