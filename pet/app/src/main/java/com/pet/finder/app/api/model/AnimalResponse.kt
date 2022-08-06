package com.pet.finder.app.api.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class AnimalResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: String,
    @SerializedName("size") val size: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("contact") val contact: ContactResponse,
    @SerializedName("photos") val photos: List<PhotoResponse>?
)