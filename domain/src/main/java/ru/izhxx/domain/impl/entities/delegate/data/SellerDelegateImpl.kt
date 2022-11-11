package ru.izhxx.domain.impl.entities.delegate.data

import ru.izhxx.domain.impl.entities.delegate.SellerDelegate

data class SellerDelegateImpl(
    override val id: Int,
    var sellerData: List<SellerDelegate>
): SellerDelegate