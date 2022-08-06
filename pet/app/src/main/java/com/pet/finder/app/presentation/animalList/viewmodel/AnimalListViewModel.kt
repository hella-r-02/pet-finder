package com.pet.finder.app.presentation.animalList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.domain.AnimalRepository
import kotlinx.coroutines.launch

class AnimalListViewModel (private val animalRepository: AnimalRepository) :
    ViewModel() {
    private val _mutableLiveDataAnimals = MutableLiveData<List<Animal>>(emptyList())
    val liveDataAnimals get() = _mutableLiveDataAnimals

    fun loadMovies() {
        viewModelScope.launch {
            val animals = animalRepository.getAnimals()
            _mutableLiveDataAnimals.value = animals
        }
    }
}