package com.pet.finder.app.di

import android.content.Context
import com.pet.finder.app.domain.AnimalRepository
import com.pet.finder.app.presentation.animalDetails.viewmodel.AnimalDetailsViewModelFactory
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideAnimalListViewModelFactory(animalRepository: AnimalRepository): AnimalListViewModelFactory {
        return AnimalListViewModelFactory(animalRepository = animalRepository)
    }

    @Provides
    fun provideAnimalDetailsViewModelFactory(animalRepository: AnimalRepository): AnimalDetailsViewModelFactory {
        return AnimalDetailsViewModelFactory(animalRepository = animalRepository)
    }
}