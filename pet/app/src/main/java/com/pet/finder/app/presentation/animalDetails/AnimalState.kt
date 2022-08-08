package com.pet.finder.app.presentation.animalDetails

import com.pet.finder.app.data.model.AnimalDetails


sealed class AnimalState {
    class DefaultState(val animal: AnimalDetails?) : AnimalState()
    class ErrorState(val animal: AnimalDetails?) : AnimalState()
}