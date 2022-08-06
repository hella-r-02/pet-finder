package com.pet.finder.app.api.dataSource

import com.pet.finder.app.api.ImageAppender
import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.data.model.Animal

class RetrofitAnimalDataSourceImpl(
    private val animalService: AnimalService
) : RetrofitAnimalDataSource {
    override suspend fun getAnimalsList(): List<Animal> {
        val animalsResponse = animalService.getAnimals()
        return animalsResponse.animals.map { animal ->
            val address = animal.contact.address
            Animal(
                id = animal.id,
                name = animal.name,
                size = animal.size,
                age = animal.age,
                gender = animal.gender,
                location = address.city + ", " + address.country + ", " + address.state,
                photo = ImageAppender().buildUrl(animal.photos)
            )
        }
    }
}