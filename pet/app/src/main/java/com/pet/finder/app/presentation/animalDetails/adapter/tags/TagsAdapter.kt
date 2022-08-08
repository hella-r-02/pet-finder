package com.pet.finder.app.presentation.animalDetails.adapter.tags

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pet.finder.app.R

class TagsAdapter : ListAdapter<String, TagsAdapter.DataViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_tag, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tag = itemView.findViewById<TextView>(R.id.tv_tag)
        fun onBind(tag: String) {
            this.tag.text = tag
        }

        private val RecyclerView.ViewHolder.context
            get() = this.itemView.context
    }

}

private class DiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}