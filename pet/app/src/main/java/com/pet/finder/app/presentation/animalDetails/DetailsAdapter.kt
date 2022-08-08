package com.pet.finder.app.presentation.animalDetails

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pet.finder.app.data.model.AnimalDetails

class DetailsAdapter : ListAdapter<AnimalDetails, DetailsAdapter.DataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("ResourceAsColor")
        fun onBind(animal: AnimalDetails) {
        }

        private val RecyclerView.ViewHolder.context
            get() = this.itemView.context
    }
}

class DiffCallback : DiffUtil.ItemCallback<AnimalDetails>() {
    override fun areItemsTheSame(oldItem: AnimalDetails, newItem: AnimalDetails): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: AnimalDetails, newItem: AnimalDetails): Boolean {
        return oldItem == newItem
    }
}