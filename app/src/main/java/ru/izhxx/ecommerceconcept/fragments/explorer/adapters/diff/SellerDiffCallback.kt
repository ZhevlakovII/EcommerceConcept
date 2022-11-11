package ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import ru.izhxx.domain.impl.entities.ProductSeller
import ru.izhxx.domain.impl.entities.delegate.SellerDelegate
import ru.izhxx.ecommerceconcept.model.categories.Category

class SellerDiffCallback: DiffUtil.ItemCallback<SellerDelegate>() {
    override fun areItemsTheSame(oldItem: SellerDelegate, newItem: SellerDelegate): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SellerDelegate, newItem: SellerDelegate): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}