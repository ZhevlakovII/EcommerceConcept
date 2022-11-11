package ru.izhxx.ecommerceconcept.model.base

import androidx.recyclerview.widget.DiffUtil
import ru.izhxx.domain.impl.entities.delegate.Delegate

open class BaseDiffCallback: DiffUtil.ItemCallback<Delegate>() {
    override fun areItemsTheSame(oldItem: Delegate, newItem: Delegate): Boolean =
        oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(oldItem: Delegate, newItem: Delegate): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}