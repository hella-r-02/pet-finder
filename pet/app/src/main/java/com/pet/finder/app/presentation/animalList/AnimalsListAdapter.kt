package com.pet.finder.app.presentation.animalList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pet.finder.app.R
import com.pet.finder.app.data.model.Animal

class AnimalsListAdapter(private val onClickCard: (item: Animal) -> Unit) :
    ListAdapter<Animal, AnimalsListAdapter.DataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_animal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item, onClickCard)
    }
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageAnimal: ImageView = itemView.findViewById(R.id.iv_pet_image)
        private val animalName: TextView = itemView.findViewById(R.id.tv_pet_name)
        private val animalAge: TextView = itemView.findViewById(R.id.tv_pet_age)
        private val location: TextView = itemView.findViewById(R.id.tv_location)
        private val animalGender: TextView = itemView.findViewById(R.id.tv_gender)

        @SuppressLint("ResourceAsColor")
        fun onBind(animal: Animal, onClickCard: (item: Animal) -> Unit) {
            Glide.with(context)
                .load(animal.photo)
                .placeholder(R.drawable.ic_animal_placeholder)
                .into(imageAnimal)
            animalName.text = animal.name
            animalAge.text = animal.age
            location.text = animal.location
            val gender = animal.gender
            when (gender) {
                "Male" -> {
                    animalGender.background =
                        ContextCompat.getDrawable(context, R.drawable.male_background)
                    animalGender.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.male_text_color
                        )
                    )
                }
                "Female" -> {
                    animalGender.background =
                        ContextCompat.getDrawable(context, R.drawable.female_background)
                    animalGender.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.female_text_color
                        )
                    )
                }
            }
            animalGender.text = gender
            itemView.setOnClickListener {
                println("fkj")
                onClickCard(animal)
            }
        }

        private val RecyclerView.ViewHolder.context
            get() = this.itemView.context
    }

}

class DiffCallback : DiffUtil.ItemCallback<Animal>() {
    override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
        return oldItem == newItem
    }
}