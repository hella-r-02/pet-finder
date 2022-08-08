package com.pet.finder.app.data.model

class AnimalDetails(
    val id: Int,
    val name: String,
    val description: String?,
    val breeds: Breed,
    val age: String,
    val location: String,
    val gender: String,
    val contact: Contact?,
    val photos: String?,
    val tags: List<String>?,
)