package com.pet.finder.app.api.dataSource

import com.pet.finder.app.data.model.Animal

interface RetrofitAnimalDataSource {
   suspend fun getAnimalsList():List<Animal>
}