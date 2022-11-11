package ru.izhxx.domain.api.usecases

import ru.izhxx.domain.impl.entities.ProductDetail

interface GetProductDetailUseCase {
    suspend fun invoke(productId: Int): ProductDetail?
}