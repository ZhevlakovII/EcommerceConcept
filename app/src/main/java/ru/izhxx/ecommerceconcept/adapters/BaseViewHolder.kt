package ru.izhxx.ecommerceconcept.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<out V: ViewBinding, in I: Any>(
    private val binding: V
    ): RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: I)
}