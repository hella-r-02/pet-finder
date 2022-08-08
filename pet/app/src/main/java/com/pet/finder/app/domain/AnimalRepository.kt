package com.pet.finder.app.domain

import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.data.model.AnimalDetails

interface AnimalRepository {
   suspend fun getAnimals(): List<Animal>
   suspend fun getAnimalById(id:Int):AnimalDetails
}