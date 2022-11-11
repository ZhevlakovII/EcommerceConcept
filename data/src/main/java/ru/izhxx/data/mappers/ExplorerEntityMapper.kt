package ru.izhxx.data.mappers

import ru.izhxx.data.entities.explorer.BestSellers
import ru.izhxx.data.entities.explorer.Explorer
import ru.izhxx.data.entities.explorer.HomeStore
import ru.izhxx.domain.impl.entities.ProductSeller
import ru.izhxx.domain.impl.entities.ProductExplorer
import ru.izhxx.domain.impl.entities.ProductHot

class ExplorerEntityMapper {
    fun toProductExplorer(explorer: Explorer): ProductExplorer {
        return ProductExplorer(
            productsHot = getProductsHot(explorer.homeStore),
            productSellers = getBestSellers(explorer.bestSellers)
        )
    }

    private fun getBestSellers(bestSellers: List<BestSellers>): List<ProductSeller> {
        return bestSellers.map {
            ProductSeller(
                id = it.id,
                name = it.title,
                pictureUrl = it.pictureUrl,
                isFavorite = it.isFavorites,
                price = it.price,
                discountPrice = it.discountPrice
            )
        }
    }

    private fun getProductsHot(homeStore: List<HomeStore>): List<ProductHot> {
        return homeStore.map {
            ProductHot(
                id = it.id,
                name = it.title,
                description = it.subtitle,
                pictureUrl = it.pictureUrl,
                isNew = it.isNew,
                isBuy = it.isBuy
            )
        }
    }
}
