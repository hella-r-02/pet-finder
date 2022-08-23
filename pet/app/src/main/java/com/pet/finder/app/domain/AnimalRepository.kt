package com.pet.finder.app.domain

import com.pet.finder.app.domain.model.Animal

interface AnimalRepository {
   suspend fun getAnimals(): List<Animal>
   suspend fun getAnimalById(id:Int): Animal
}