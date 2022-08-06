package com.pet.finder.app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Session(
    val tokenType: String,
    val expiresIn: Int,
    val accessToken: String
)