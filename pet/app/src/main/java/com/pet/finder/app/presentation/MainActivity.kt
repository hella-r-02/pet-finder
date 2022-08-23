package com.pet.finder.app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pet.finder.app.R
import com.pet.finder.app.app.App
import com.pet.finder.app.domain.model.Animal
import com.pet.finder.app.presentation.animalDetails.AnimalDetailsFragment
import com.pet.finder.app.presentation.animalDetails.viewmodel.AnimalDetailsViewModel
import com.pet.finder.app.presentation.animalDetails.viewmodel.AnimalDetailsViewModelFactory
import com.pet.finder.app.presentation.animalList.AnimalsListFragment
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModel
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), AnimalsListFragment.AnimalsListItemClickListener {
    @Inject
    lateinit var animalListViewModelFactory: AnimalListViewModelFactory

    @Inject
    lateinit var animalDetailsViewModelFactory: AnimalDetailsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).appComponent.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.apply {
                beginTransaction()
                    .replace(R.id.frame_layout_container, AnimalsListFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    fun getAnimalListViewModel(): AnimalListViewModel =
        ViewModelProvider(this, animalListViewModelFactory).get(AnimalListViewModel::class.java)

    fun getAnimalDetailsViewModel(): AnimalDetailsViewModel =
        ViewModelProvider(
            this,
            animalDetailsViewModelFactory
        ).get(AnimalDetailsViewModel::class.java)

    override fun onAnimalSelected(animal: Animal) {
        val bundle = Bundle()
        bundle.putInt("animal_id", animal.id)
        val fragment = AnimalDetailsFragment()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}