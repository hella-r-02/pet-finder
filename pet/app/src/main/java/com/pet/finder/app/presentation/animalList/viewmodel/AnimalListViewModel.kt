package com.pet.finder.app.presentation.animalList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pet.finder.app.data.model.Animal
import com.pet.finder.app.domain.AnimalRepository
import kotlinx.coroutines.launch

class AnimalListViewModel(private val animalRepository: AnimalRepository) :
    ViewModel() {
    private val _mutableLiveDataAnimals = MutableLiveData<List<Animal>>(emptyList())
    val liveDataAnimals get() = _mutableLiveDataAnimals

    fun loadAnimals() {
        viewModelScope.launch {
            val animals = animalRepository.getAnimals()
            animals.forEach { println(it) }
            _mutableLiveDataAnimals.value = animals
        }
    }
}