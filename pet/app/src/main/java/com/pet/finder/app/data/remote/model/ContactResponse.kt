package com.pet.finder.app.data.remote.model

import com.google.gson.annotations.SerializedName

class ContactResponse(
    @SerializedName("address") val address: AddressResponse
)