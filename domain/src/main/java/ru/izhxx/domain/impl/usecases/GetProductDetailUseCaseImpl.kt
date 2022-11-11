package ru.izhxx.domain.impl.usecases

import ru.izhxx.domain.api.repositories.ProductRepository
import ru.izhxx.domain.api.usecases.GetProductDetailUseCase
import ru.izhxx.domain.impl.entities.ProductDetail

class GetProductDetailUseCaseImpl(
    private val productRepository: ProductRepository
): GetProductDetailUseCase {
    override suspend fun invoke(productId: Int): ProductDetail? {
        return productRepository.getProductDetail(productId)
    }

}