package ru.izhxx.ecommerceconcept.fragments.details.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.databinding.DetailRecyclerImagesBinding

class DetailsViewHolder(
    private val binding: DetailRecyclerImagesBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.itemImage.load(item) {
            placeholder(R.drawable.picture_samsung)
        }
    }
}