package com.pet.finder.app.presentation.animalDetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pet.finder.app.domain.AnimalRepository
import javax.inject.Inject

class AnimalDetailsViewModelFactory @Inject constructor(val animalRepository: AnimalRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        AnimalDetailsViewModel(animalRepository) as T
}