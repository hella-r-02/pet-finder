package com.pet.finder.app.domain.model

class AnimalDetails(
    val id: Int,
    val name: String,
    val description: String?,
    val age: String,
    val location: String,
    val gender: String,
    val contact: Contact?,
    val photos: String?,
    val tags: List<String>?,
    val details: List<Details>,
    val organization: Organization?
)