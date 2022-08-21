package com.pet.finder.app.data.remote.service

import com.pet.finder.app.data.remote.model.AnimalDetailsMainResponse
import com.pet.finder.app.data.remote.model.AnimalsResponse
import retrofit2.http.*

interface AnimalService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("animals")
    suspend fun getAnimals(): AnimalsResponse

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("animals/{id}")
    suspend fun getAnimalById(@Path("id") id: Int): AnimalDetailsMainResponse
}