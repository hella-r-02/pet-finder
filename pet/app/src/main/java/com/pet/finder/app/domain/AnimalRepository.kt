package com.pet.finder.app.domain

import com.pet.finder.app.data.model.Animal

interface AnimalRepository {
   suspend fun getAnimals(): List<Animal>
}