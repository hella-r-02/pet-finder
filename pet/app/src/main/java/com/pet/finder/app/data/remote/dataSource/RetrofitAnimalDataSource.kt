package com.pet.finder.app.data.remote.dataSource

import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.data.model.AnimalDetails

interface RetrofitAnimalDataSource {
    suspend fun getAnimalsList(): List<Animal>
    suspend fun getAnimal(id: Int): AnimalDetails
}