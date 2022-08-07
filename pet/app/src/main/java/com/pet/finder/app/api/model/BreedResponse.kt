package com.pet.finder.app.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BreedResponse(
    @SerialName("primary") val primary: String?,
    @SerialName("secondary") val secondary:String?,
    @SerialName("mixed") val mixed:Boolean,
    @SerialName("unknown") val unknown:Boolean
)