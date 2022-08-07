package com.pet.finder.app.api

import com.pet.finder.app.api.model.PhotoResponse

class ImageAppender {
    fun buildUrl(photos: List<PhotoResponse>?): String? {
        if (photos == null || photos.isEmpty()) {
            return null
        }
        val photo = photos.get(0)
        if (photo.large != null) {
            return photo.large
        }
        if (photo.full != null) {
            return photo.full
        }
        if (photo.medium != null) {
            return photo.medium
        }
        return photo.small
    }
}