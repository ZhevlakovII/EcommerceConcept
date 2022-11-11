package ru.izhxx.data.repositories

import ru.izhxx.data.datasources.api.CartDataSource
import ru.izhxx.data.datasources.api.DetailsDataSource
import ru.izhxx.data.datasources.api.ExplorerDataSource
import ru.izhxx.domain.api.repositories.ProductRepository
import ru.izhxx.domain.impl.entities.ProductDetail
import ru.izhxx.domain.impl.entities.ProductExplorer
import ru.izhxx.domain.impl.entities.UserBasket

class ProductRepositoryImpl(
    private val cartDataSource: CartDataSource,
    private val detailsDataSource: DetailsDataSource,
    private val explorerDataSource: ExplorerDataSource
): ProductRepository {
    override suspend fun getProductExplorer(): ProductExplorer? {
        return explorerDataSource.getExplorerData()
    }

    override suspend fun getUserBasket(userId: Int): UserBasket? {
        return cartDataSource.getCartData()
    }

    override suspend fun getProductDetail(productId: Int): ProductDetail? {
        return detailsDataSource.getDetailData()
    }
}