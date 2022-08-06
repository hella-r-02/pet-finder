package com.pet.finder.app.api.model

import kotlinx.serialization.Serializable

@Serializable
class PhotosResponse(
    val photos: List<PhotoResponse>?
)