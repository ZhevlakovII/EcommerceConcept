package ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import ru.izhxx.domain.impl.entities.delegate.CategoryDelegate
import ru.izhxx.ecommerceconcept.model.categories.Category

class CategoryDiffCallback: DiffUtil.ItemCallback<CategoryDelegate>() {
    override fun areItemsTheSame(oldItem: CategoryDelegate, newItem: CategoryDelegate): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CategoryDelegate, newItem: CategoryDelegate): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}