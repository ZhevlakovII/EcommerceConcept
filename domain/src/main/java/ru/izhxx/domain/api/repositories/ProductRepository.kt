package ru.izhxx.domain.api.repositories

import ru.izhxx.domain.impl.entities.ProductDetail
import ru.izhxx.domain.impl.entities.ProductExplorer
import ru.izhxx.domain.impl.entities.UserBasket

interface ProductRepository {
    suspend fun getProductExplorer(): ProductExplorer?

    suspend fun getUserBasket(userId: Int): UserBasket?

    suspend fun getProductDetail(productId: Int): ProductDetail?
}