package ru.izhxx.ecommerceconcept.fragments.details.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.izhxx.ecommerceconcept.databinding.DetailRecyclerImagesBinding

class DetailsAdapter(): ListAdapter<String, DetailsViewHolder>(DetailsAdapterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            DetailRecyclerImagesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}