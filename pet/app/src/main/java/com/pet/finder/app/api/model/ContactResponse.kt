package com.pet.finder.app.api.model

import com.google.gson.annotations.SerializedName

class ContactResponse(
    @SerializedName("address") val address: AddressResponse
)