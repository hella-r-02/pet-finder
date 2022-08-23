package com.pet.finder.app.presentation.animalDetails

import com.pet.finder.app.domain.model.Animal


sealed class AnimalState {
    class DefaultState(val animal: Animal?) : AnimalState()
    class ErrorState(val animal: Animal?) : AnimalState()
}