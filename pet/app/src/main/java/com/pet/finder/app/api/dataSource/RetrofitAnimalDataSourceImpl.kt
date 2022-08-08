package com.pet.finder.app.api.dataSource

import com.pet.finder.app.api.ImageAppender
import com.pet.finder.app.api.model.AnimalDetailsResponse
import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.data.model.AnimalDetails
import com.pet.finder.app.data.model.Breed
import com.pet.finder.app.data.model.Contact

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
                age = animal.age,
                gender = animal.gender,
                location = address.city + ", " + address.state + ", " + address.country,
                photo = ImageAppender().buildUrl(animal.photos)
            )
        }
    }

    override suspend fun getAnimal(id: Int): AnimalDetails {
        val animalResponse: AnimalDetailsResponse = animalService.getAnimalById(id).animal
        val breeds = animalResponse.breeds
        val address = animalResponse.contact.address
        return AnimalDetails(
            id = animalResponse.id,
            name = animalResponse.name,
            description = animalResponse.description,
            breeds = Breed(
                primary = breeds.primary,
                secondary = breeds.secondary,
                mixed = breeds.mixed,
                unknown = breeds.unknown
            ),
            location = address.city + ", " + address.state + ", " + address.country,
            age = animalResponse.age,
            gender = animalResponse.gender,
            contact = Contact(
                phone = animalResponse.contact.phone,
                email = animalResponse.contact.email,
            ),
            photos = ImageAppender().buildUrl(animalResponse.photos),
            tags = animalResponse.tags
        )
    }
}