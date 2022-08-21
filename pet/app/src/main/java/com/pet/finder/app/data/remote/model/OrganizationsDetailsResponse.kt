package com.pet.finder.app.data.remote.model

import com.google.gson.annotations.SerializedName

class OrganizationsDetailsResponse(
    @SerializedName("organization")
    val organization: OrganizationResponse
)