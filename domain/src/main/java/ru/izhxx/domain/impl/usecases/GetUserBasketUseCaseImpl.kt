package ru.izhxx.domain.impl.usecases

import ru.izhxx.domain.api.repositories.ProductRepository
import ru.izhxx.domain.api.usecases.GetUserBasketUseCase
import ru.izhxx.domain.impl.entities.UserBasket

class GetUserBasketUseCaseImpl(
    private val productRepository: ProductRepository
): GetUserBasketUseCase {
    override suspend fun invoke(userId: Int): UserBasket? {
        return productRepository.getUserBasket(userId)
    }

}