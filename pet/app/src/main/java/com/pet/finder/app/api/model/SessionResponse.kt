package com.pet.finder.app.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class SessionResponse(
    @SerializedName("token_type")
    @Expose
    val tokenType: String,
    @SerializedName("expires_in")
    @Expose
    val expiresIn: Int,
    @SerializedName("access_token")
    @Expose
    val accessToken: String
)