package com.pet.finder.app.api.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class ContactDetailsResponse(
    @SerializedName("address")
    val address: AddressResponse,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("email")
    val email: String?
)