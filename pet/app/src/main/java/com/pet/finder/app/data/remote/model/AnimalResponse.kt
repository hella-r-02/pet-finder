package com.pet.finder.app.data.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class AnimalResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("organization_id")
    val organizationId: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("photos")
    val photos: List<PhotoResponse>?,
    @SerializedName("breeds")
    val breeds: BreedsResponse,
    @SerializedName("age")
    val age: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("contact")
    val contact: ContactDetailsResponse,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("size")
    val size: String
)