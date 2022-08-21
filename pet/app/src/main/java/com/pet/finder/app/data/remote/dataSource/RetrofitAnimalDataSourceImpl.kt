package com.pet.finder.app.data.remote.dataSource

import com.pet.finder.app.data.remote.ImageAppender
import com.pet.finder.app.data.remote.model.AnimalDetailsResponse
import com.pet.finder.app.data.remote.model.BreedsResponse
import com.pet.finder.app.data.remote.service.AnimalService
import com.pet.finder.app.data.remote.service.OrganizationService
import com.pet.finder.app.data.model.*

class RetrofitAnimalDataSourceImpl(
    private val animalService: AnimalService,
    private val organizationService: OrganizationService
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
        val address = animalResponse.contact.address
        val detailsResponse = listOf(
            Details(key = "size", value = animalResponse.size),
            Details(key = "breed", value = parseBreeds(breeds = animalResponse.breeds))
        )
        var organization: Organization? = null
        if (animalResponse.organizationId != null) {
            val organizationResponse =
                organizationService.getOrganization(animalResponse.organizationId)
            organization = Organization(
                id = organizationResponse.organization.id,
                name = organizationResponse.organization.name,
                photo = ImageAppender().buildUrl(organizationResponse.organization.photos)
            )
        }
        return AnimalDetails(
            id = animalResponse.id,
            name = animalResponse.name,
            description = animalResponse.description,
            details = detailsResponse,
            location = address.city + ", " + address.state + ", " + address.country,
            age = animalResponse.age,
            gender = animalResponse.gender,
            contact = Contact(
                phone = animalResponse.contact.phone,
                email = animalResponse.contact.email,
            ),
            photos = ImageAppender().buildUrl(animalResponse.photos),
            tags = animalResponse.tags,
            organization = organization
        )
    }

    private fun parseBreeds(breeds: BreedsResponse): String {
        var result = ""
        if (breeds.primary != null) {
            result += breeds.primary
            if (breeds.secondary != null) {
                result += " x ${breeds.secondary}"
            }
            return result
        }
        return "unknown"
    }
}