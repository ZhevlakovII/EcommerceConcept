package ru.izhxx.ecommerceconcept.fragments.explorer.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.izhxx.domain.impl.entities.delegate.Delegate
import ru.izhxx.domain.impl.entities.delegate.HotDelegate
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.delegates.Delegates
import ru.izhxx.ecommerceconcept.fragments.explorer.adapters.diff.HotDiffCallback
import ru.izhxx.ecommerceconcept.model.base.BaseDiffCallback

class ItemHotAdapter(): AsyncListDifferDelegationAdapter<Delegate>(BaseDiffCallback()) {
    init {
        delegatesManager.addDelegate(Delegates.itemHotDelegate)
    }
}