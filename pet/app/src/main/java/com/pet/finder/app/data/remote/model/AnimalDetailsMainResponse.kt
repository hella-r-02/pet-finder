package com.pet.finder.app.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AnimalDetailsMainResponse(
    @SerialName("animal")
    val animal: AnimalDetailsResponse
)