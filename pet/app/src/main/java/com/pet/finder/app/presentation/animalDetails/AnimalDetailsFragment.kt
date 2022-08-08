package com.pet.finder.app.presentation.animalDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pet.finder.app.R
import com.pet.finder.app.data.model.AnimalDetails
import com.pet.finder.app.databinding.FragmentAnimalDetailsBinding
import com.pet.finder.app.presentation.MainActivity
import com.pet.finder.app.presentation.animalDetails.adapter.details.DetailsAdapter
import com.pet.finder.app.presentation.animalDetails.adapter.tags.TagsAdapter
import com.pet.finder.app.presentation.animalDetails.viewmodel.AnimalDetailsViewModel

class AnimalDetailsFragment : Fragment() {
    private lateinit var animalDetailsViewModel: AnimalDetailsViewModel
    private var animalId: Int? = null

    private lateinit var detailsAdapter: DetailsAdapter
    private lateinit var tagsAdapter: TagsAdapter
    private lateinit var binding: FragmentAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animalDetailsViewModel = (activity as MainActivity).getAnimalDetailsViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = this.arguments
        animalId = args?.get("animal_id") as Int
        return inflater.inflate(R.layout.fragment_animal_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimalDetailsBinding.bind(view)
        animalDetailsViewModel.liveDataAnimal.observe(
            this.viewLifecycleOwner, this::setState
        )
        animalDetailsViewModel.loadAnimal(animalId!!)
    }

    private fun setAdapterForDetailsRecyclerView(animal: AnimalDetails) {
        detailsAdapter = DetailsAdapter()
        detailsAdapter.submitList(animal.details)
        val layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.VERTICAL, false)
        binding.rvDetails.layoutManager = layoutManager
        binding.rvDetails.adapter = detailsAdapter
        binding.rvDetails.isNestedScrollingEnabled = false
    }

    private fun setAdapterForTagsRecyclerView(animal: AnimalDetails) {
        tagsAdapter = TagsAdapter()
        tagsAdapter.submitList(animal.tags)
        val layoutManager = GridLayoutManager(requireContext(), 1, RecyclerView.HORIZONTAL, false)
        binding.rvTags.layoutManager = layoutManager
        binding.rvTags.adapter = tagsAdapter
        binding.rvTags.isNestedScrollingEnabled = false
    }

    private fun setState(state: AnimalState) {
        when (state) {
            is AnimalState.DefaultState -> state.animal?.let { loadData(it) }
            is AnimalState.ErrorState -> Toast.makeText(
                requireContext(),
                "Movie loading error",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun loadData(animal: AnimalDetails) {
        setAdapterForDetailsRecyclerView(animal)
        setAdapterForTagsRecyclerView(animal)
        Glide.with(requireContext())
            .load(animal.photos)
            .placeholder(R.drawable.ic_animal_placeholder)
            .into(binding.ivAnimalImage)
        binding.tvAnimalName.text = animal.name
        binding.tvAnimalAge.text = animal.age
        binding.tvLocation.text = animal.location
        if (animal.description == null || animal.description.isEmpty()) {
            binding.tvAboutMeTitle.visibility = View.GONE
            binding.tvAboutMe.visibility = View.GONE
        } else {
            binding.tvAboutMe.text = animal.description
        }
        binding.tvGender.text = animal.gender
        when (animal.gender) {
            "Male" -> {
                binding.tvGender.background =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.male_background
                    )
                binding.tvGender.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.male_text_color
                    )
                )
            }
            "Female" -> {
                binding.tvGender.background =
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.female_background
                    )
                binding.tvGender.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.female_text_color
                    )
                )
            }
        }
        loadOrganizationInformation(animal)
    }

    private fun loadOrganizationInformation(animal: AnimalDetails) {
        if (animal.organization != null) {
            Glide.with(requireContext())
                .load(animal.organization.photo)
                .placeholder(R.drawable.organization_title)
                .into(binding.ivOrganization)
            binding.tvOrganizationName.text = animal.organization.name
            binding.tvOrganizationLocation.text = animal.location
        } else {
            println("kfkfkf")
            binding.viewOrganization.visibility = View.GONE
        }
    }
}