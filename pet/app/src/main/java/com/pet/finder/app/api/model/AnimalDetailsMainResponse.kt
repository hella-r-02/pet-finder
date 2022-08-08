package com.pet.finder.app.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AnimalDetailsMainResponse(
    @SerialName("animal")
    val animal: AnimalDetailsResponse
)