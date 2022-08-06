package com.pet.finder.app.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pet.finder.app.R
import com.pet.finder.app.app.App
import com.pet.finder.app.presentation.animalList.AnimalsListFragment
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModel
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vmFactory: AnimalListViewModelFactory

    private lateinit var vm: AnimalListViewModel
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
        ViewModelProvider(this, vmFactory).get(AnimalListViewModel::class.java)
}