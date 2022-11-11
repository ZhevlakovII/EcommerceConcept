package ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import ru.izhxx.domain.impl.entities.delegate.HotDelegate

class HotDiffCallback: DiffUtil.ItemCallback<HotDelegate>() {
    override fun areItemsTheSame(oldItem: HotDelegate, newItem: HotDelegate): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HotDelegate, newItem: HotDelegate): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}