package com.pet.finder.app.presentation.animalList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pet.finder.app.R
import com.pet.finder.app.domain.model.Animal
import com.pet.finder.app.databinding.FragmentAnimalsListBinding
import com.pet.finder.app.presentation.MainActivity
import com.pet.finder.app.presentation.animalList.viewmodel.AnimalListViewModel

class AnimalsListFragment : Fragment() {
    private lateinit var viewModel: AnimalListViewModel
    private lateinit var adapter: AnimalsListAdapter
    private lateinit var binding: FragmentAnimalsListBinding
    private var itemClickListener: AnimalsListItemClickListener? = null

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AnimalsListItemClickListener) {
            itemClickListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimalsListBinding.bind(view)
        setAdapterForRecyclerView()
        viewModel.liveDataAnimals.observe(
            this.viewLifecycleOwner
        ) { animals -> adapter.submitList(animals) }
        viewModel.loadAnimals()
    }

    private fun setAdapterForRecyclerView() {
        adapter = AnimalsListAdapter { animals -> itemClickListener?.onAnimalSelected(animals) }
        val layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        binding.rvAnimals.layoutManager = layoutManager
        binding.rvAnimals.adapter = adapter
        binding.rvAnimals.isNestedScrollingEnabled = false
    }

    interface AnimalsListItemClickListener {
        fun onAnimalSelected(animal: Animal)
    }
}