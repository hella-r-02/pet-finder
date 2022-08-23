package com.pet.finder.app.data.repository

import com.pet.finder.app.data.remote.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.domain.model.Animal
import com.pet.finder.app.domain.AnimalRepository

class AnimalRepositoryImpl(
    private val retrofitAnimalDataSource: RetrofitAnimalDataSource
) : AnimalRepository {
    override suspend fun getAnimals(): List<Animal> {
        return retrofitAnimalDataSource.getAnimalsList()
    }

    override suspend fun getAnimalById(id: Int): Animal {
        return retrofitAnimalDataSource.getAnimal(id)
    }
}