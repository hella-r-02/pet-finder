package com.pet.finder.app.api.dataSource

import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.data.SessionStorage
import com.pet.finder.app.data.model.Animal
import javax.inject.Inject

class RetrofitAnimalDataSourceImpl @Inject constructor(
    private val animalService: AnimalService,
    private val sessionStorage: SessionStorage
) : RetrofitAnimalDataSource {
    override suspend fun getAnimalsList(): List<Animal> {
        val token = sessionStorage.getToken()
        val animalsResponse = animalService.getAnimals(token)
        return animalsResponse.animals.map { animal ->
            Animal(
                id = animal.id,
                name = animal.name
            )

        }
    }

}