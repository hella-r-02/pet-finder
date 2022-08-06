package com.pet.finder.app.api.servcice

import com.pet.finder.app.api.model.AnimalsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface AnimalService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("animals")
    suspend fun getAnimals(@Header("Authorization") token: String): AnimalsResponse
}