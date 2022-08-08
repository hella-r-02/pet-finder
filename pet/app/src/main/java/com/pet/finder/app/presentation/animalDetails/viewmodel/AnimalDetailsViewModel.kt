package com.pet.finder.app.presentation.animalDetails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pet.finder.app.domain.AnimalRepository
import com.pet.finder.app.presentation.animalDetails.AnimalState
import kotlinx.coroutines.launch

class AnimalDetailsViewModel(private val animalRepository: AnimalRepository) : ViewModel() {
    private val _mutableLiveDataAnimal =
        MutableLiveData<AnimalState>(AnimalState.DefaultState(null))
    val liveDataAnimal get() = _mutableLiveDataAnimal

    fun loadAnimal(id: Int) {
        viewModelScope.launch {
            val animal = animalRepository.getAnimalById(id)
            if (animal == null) {
                _mutableLiveDataAnimal.value = AnimalState.ErrorState(null)
            } else {
                _mutableLiveDataAnimal.value = AnimalState.DefaultState(animal)
            }
        }
    }
}