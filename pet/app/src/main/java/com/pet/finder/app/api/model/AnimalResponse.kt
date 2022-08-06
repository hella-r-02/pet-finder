package com.pet.finder.app.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AnimalResponse (
    @SerialName("id") val id: Int,
    @SerialName("name") val name:String,
        )