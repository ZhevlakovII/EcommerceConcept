package ru.izhxx.ecommerceconcept.fragments.cart.adapters

import ru.izhxx.domain.impl.entities.ProductBasket
import ru.izhxx.ecommerceconcept.adapters.BaseViewHolder
import ru.izhxx.ecommerceconcept.databinding.CartRecyclerItemBinding

class PurchaseViewHolder(
    private val binding: CartRecyclerItemBinding
    ): BaseViewHolder<CartRecyclerItemBinding, ProductBasket>(binding) {
    override fun bind(item: ProductBasket) {
        binding.itemButtonAdd
        binding.itemButtonDelete
        binding.itemButtonRemove

        binding.itemImage
        binding.itemTextCount.text = item.count.toString()
        binding.itemTextName.text = item.name
        binding.itemTextPrice.text = item.fullPrice.toString()
    }
}