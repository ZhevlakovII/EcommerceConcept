package ru.izhxx.domain.impl.usecases

import ru.izhxx.domain.api.repositories.ProductRepository
import ru.izhxx.domain.api.usecases.GetExplorerDataUseCase
import ru.izhxx.domain.impl.entities.ProductExplorer

class GetExplorerDataUseCaseImpl(
    private val productRepository: ProductRepository
): GetExplorerDataUseCase {
    override suspend fun invoke(): ProductExplorer? {
        return productRepository.getProductExplorer()
    }
}