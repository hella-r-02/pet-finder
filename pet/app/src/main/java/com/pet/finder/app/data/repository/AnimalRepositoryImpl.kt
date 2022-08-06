package com.pet.finder.app.data.repository

import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.api.dataSource.RetrofitSessionDataSource
import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.domain.AnimalRepository

class AnimalRepositoryImpl(
    private val retrofitAnimalDataSource: RetrofitAnimalDataSource
) : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> {
        return retrofitAnimalDataSource.getAnimalsList()
    }
}