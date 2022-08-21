package com.pet.finder.app.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AnimalsResponse(
    @SerialName("animals")
    val animals: List<AnimalResponse>
)