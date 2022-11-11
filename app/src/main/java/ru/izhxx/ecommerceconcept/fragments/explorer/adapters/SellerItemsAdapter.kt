package ru.izhxx.ecommerceconcept.fragments.explorer.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.izhxx.domain.impl.entities.delegate.Delegate
import ru.izhxx.domain.impl.entities.delegate.SellerDelegate
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.delegates.Delegates
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff.SellerDiffCallback
import ru.izhxx.ecommerceconcept.model.base.BaseDiffCallback

class SellerItemsAdapter(
    onFavoriteClick: (Int) -> Unit,
    onItemClick: (Int) -> Unit
): AsyncListDifferDelegationAdapter<Delegate>(BaseDiffCallback()) {
    init {
        delegatesManager.addDelegate(Delegates.sellerItemsAdapter(
            onFavoriteClick = onFavoriteClick,
            onItemClick = onItemClick
        ))
    }
}
