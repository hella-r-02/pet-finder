package com.pet.finder.app.api.dataSource

import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.data.model.Animal

class RetrofitAnimalDataSourceImpl(
    private val animalService: AnimalService
) : RetrofitAnimalDataSource {
    override suspend fun getAnimalsList(): List<Animal> {
        val animalsResponse = animalService.getAnimals()
        return animalsResponse.animals.map { animal ->
            Animal(
                id = animal.id,
                name = animal.name
            )
        }
    }
}