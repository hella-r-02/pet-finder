package com.pet.finder.app.presentation.animalList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pet.finder.app.R
import com.pet.finder.app.presentation.MainActivity
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModel

class AnimalsListFragment : Fragment() {
    private lateinit var viewModel: AnimalListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).getAnimalListViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animals_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveDataAnimals.observe(
            this.viewLifecycleOwner
        ) { animals -> println(animals) }
        viewModel.loadMovies()
    }
}