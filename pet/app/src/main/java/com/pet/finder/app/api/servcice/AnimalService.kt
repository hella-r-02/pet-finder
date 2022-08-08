package com.pet.finder.app.api.servcice

import com.pet.finder.app.api.model.AnimalDetailsMainResponse
import com.pet.finder.app.api.model.AnimalsResponse
import retrofit2.http.*

interface AnimalService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("animals")
    suspend fun getAnimals(): AnimalsResponse

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("animals/{id}")
    suspend fun getAnimalById(@Path("id") id: Int): AnimalDetailsMainResponse
}