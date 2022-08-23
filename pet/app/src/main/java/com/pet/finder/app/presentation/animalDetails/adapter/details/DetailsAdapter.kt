package com.pet.finder.app.presentation.animalDetails.adapter.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pet.finder.app.R
import com.pet.finder.app.domain.model.Details

class DetailsAdapter : ListAdapter<Details, DetailsAdapter.DataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val detailTitle = itemView.findViewById<TextView>(R.id.tv_detail_item_title)
        private val detail = itemView.findViewById<TextView>(R.id.tv_detail_item)

        @SuppressLint("ResourceAsColor")
        fun onBind(details: Details) {
            detailTitle.text = details.key
            detail.text = details.value
        }

        private val RecyclerView.ViewHolder.context
            get() = this.itemView.context
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Details>() {
    override fun areItemsTheSame(oldItem: Details, newItem: Details): Boolean {
        return oldItem.value == newItem.value
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Details, newItem: Details): Boolean {
        return oldItem == newItem
    }
}