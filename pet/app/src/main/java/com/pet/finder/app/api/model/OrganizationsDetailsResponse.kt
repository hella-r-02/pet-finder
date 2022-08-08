package com.pet.finder.app.api.model

import com.google.gson.annotations.SerializedName

class OrganizationsDetailsResponse(
    @SerializedName("organization")
    val organization: OrganizationResponse
)