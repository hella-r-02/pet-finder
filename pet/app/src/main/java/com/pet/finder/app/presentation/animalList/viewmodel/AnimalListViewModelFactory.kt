package com.pet.finder.app.presentation.animalList.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pet.finder.app.domain.AnimalRepository
import javax.inject.Inject

class AnimalListViewModelFactory @Inject constructor(val animalRepository: AnimalRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        AnimalListViewModel(animalRepository) as T

}