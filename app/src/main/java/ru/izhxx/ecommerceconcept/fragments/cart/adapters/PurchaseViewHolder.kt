package ru.izhxx.ecommerceconcept.fragments.cart.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.izhxx.domain.impl.entities.ProductBasket
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.databinding.CartRecyclerItemBinding

class PurchaseViewHolder(
    private val binding: CartRecyclerItemBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        item: ProductBasket,
        onAddClick: (Int) -> Unit,
        onDeleteClick: (Int) -> Unit,
        onRemoveClick: (Int) -> Unit
    ) {
        binding.itemButtonAdd.setOnClickListener { onAddClick(layoutPosition) }
        binding.itemButtonDelete.setOnClickListener { onDeleteClick(layoutPosition) }
        binding.itemButtonRemove.setOnClickListener { onRemoveClick(layoutPosition) }

        binding.itemImage.load(item.pictureUrl)
        binding.itemTextCount.text = item.count.toString()
        binding.itemTextName.text = item.name
        binding.itemTextPrice.text = buildString {
            append("$")
            append(item.price.toString())
        }
    }
}