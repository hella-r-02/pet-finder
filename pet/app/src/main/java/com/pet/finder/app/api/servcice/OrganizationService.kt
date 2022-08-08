package com.pet.finder.app.api.servcice

import com.pet.finder.app.api.model.OrganizationsDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface OrganizationService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("organizations/{id}")
    suspend fun getOrganization(@Path("id") id: String): OrganizationsDetailsResponse
}