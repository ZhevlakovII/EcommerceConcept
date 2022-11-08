package ru.izhxx.ecommerceconcept.fragments.cart.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.izhxx.domain.impl.entities.ProductBasket
import ru.izhxx.ecommerceconcept.databinding.CartRecyclerItemBinding

class PurchaseAdapter:
    ListAdapter<ProductBasket, PurchaseViewHolder>(PurchaseAdapterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        return PurchaseViewHolder(
            CartRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
