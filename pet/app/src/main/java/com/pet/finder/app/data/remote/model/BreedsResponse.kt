package com.pet.finder.app.data.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class BreedsResponse(
    @SerializedName("primary")
    val primary: String?,
    @SerializedName("secondary")
    val secondary: String?,
    @SerializedName("mixed")
    val mixed: Boolean,
    @SerializedName("unknown")
    val unknown: Boolean
)