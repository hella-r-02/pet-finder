package com.pet.finder.app.di

import android.content.Context
import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.api.dataSource.RetrofitSessionDataSource
import com.pet.finder.app.data.SessionStorage
import com.pet.finder.app.data.repository.AnimalRepositoryImpl
import com.pet.finder.app.data.storage.sharedprefs.SessionStorageImpl
import com.pet.finder.app.domain.AnimalRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideSessionStorage(
        context: Context,
        retrofitSessionDataSource: RetrofitSessionDataSource
    ): SessionStorage {
        return SessionStorageImpl(
            context = context,
            retrofitSessionDataSource = retrofitSessionDataSource
        )
    }

    @Provides
    fun provideAnimalRepository(retrofitAnimalDataSource: RetrofitAnimalDataSource): AnimalRepository {
        return AnimalRepositoryImpl(retrofitAnimalDataSource)
    }
}