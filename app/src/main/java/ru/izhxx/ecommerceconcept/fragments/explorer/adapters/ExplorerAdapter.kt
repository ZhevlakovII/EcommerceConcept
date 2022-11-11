package ru.izhxx.ecommerceconcept.fragments.explorer.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import ru.izhxx.domain.impl.entities.delegate.Delegate
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.delegates.Delegates
import ru.izhxx.ecommerceconcept.model.base.BaseDiffCallback

class ExplorerAdapter(
    private val onCategoryClick: (Int) -> Unit,
    private val onSellerFavoriteClick: (Int) -> Unit,
    private val onSellerItemClick: (Int) -> Unit
): AsyncListDifferDelegationAdapter<Delegate>(BaseDiffCallback()) {
    init {
        delegatesManager.addDelegate(Delegates.categoryDelegate { onCategoryClick(it) })
            .addDelegate(Delegates.searchDelegate)
            .addDelegate(Delegates.hotDelegate())
            .addDelegate(Delegates.sellersDelegate(
                onFavoriteClick = { onSellerFavoriteClick(it) },
                onItemClick = { onSellerItemClick(it) }
            ))
    }
}