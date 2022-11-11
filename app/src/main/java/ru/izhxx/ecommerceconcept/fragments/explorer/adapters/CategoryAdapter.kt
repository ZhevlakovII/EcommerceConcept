package ru.izhxx.ecommerceconcept.fragments.explorer.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.delegates.Delegates
import ru.izhxx.domain.impl.entities.delegate.CategoryDelegate
import ru.izhxx.domain.impl.entities.delegate.Delegate
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff.CategoryDiffCallback
import ru.izhxx.ecommerceconcept.model.base.BaseDiffCallback

class CategoryAdapter(
    private val onClick: (Int) -> Unit
): AsyncListDifferDelegationAdapter<Delegate>(BaseDiffCallback()) {
    init {
        delegatesManager.addDelegate(Delegates.categoryButtonsDelegate { onClick(it) })
    }
}