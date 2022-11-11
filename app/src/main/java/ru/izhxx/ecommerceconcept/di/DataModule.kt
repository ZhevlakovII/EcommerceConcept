package ru.izhxx.ecommerceconcept.di

import org.koin.dsl.module
import ru.izhxx.data.api.CartResponse
import ru.izhxx.data.api.DetailsResponse
import ru.izhxx.data.api.ExplorerResponse
import ru.izhxx.data.datasources.api.CartDataSource
import ru.izhxx.data.datasources.api.DetailsDataSource
import ru.izhxx.data.datasources.api.ExplorerDataSource
import ru.izhxx.data.datasources.impl.CartDataSourceImpl
import ru.izhxx.data.datasources.impl.DetailsDataSourceImpl
import ru.izhxx.data.datasources.impl.ExplorerDataSourceImpl
import ru.izhxx.data.mappers.CartEntityMapper
import ru.izhxx.data.mappers.DetailEntityMapper
import ru.izhxx.data.mappers.ExplorerEntityMapper
import ru.izhxx.data.repositories.ProductRepositoryImpl
import ru.izhxx.domain.api.repositories.ProductRepository
import ru.izhxx.ecommerceconcept.BuildConfig.BASE_URL

val dataModule = module {
    single<CartDataSource> {
        CartDataSourceImpl(
            cartResponse = CartResponse.create(BASE_URL),
            mapper = CartEntityMapper()
        )
    }

    single<DetailsDataSource> {
        DetailsDataSourceImpl(
            detailsResponse = DetailsResponse.create(BASE_URL),
            mapper = DetailEntityMapper()
        )
    }

    single<ExplorerDataSource> {
        ExplorerDataSourceImpl(
            explorerResponse = ExplorerResponse.create(BASE_URL),
            mapper = ExplorerEntityMapper()
        )
    }

    single<ProductRepository> {
        ProductRepositoryImpl(
            cartDataSource = get(),
            detailsDataSource = get(),
            explorerDataSource = get()
        )
    }
}