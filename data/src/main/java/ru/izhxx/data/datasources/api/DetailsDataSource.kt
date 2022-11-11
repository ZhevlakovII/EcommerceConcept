package ru.izhxx.data.datasources.api

import ru.izhxx.domain.impl.entities.ProductDetail

interface DetailsDataSource {
    suspend fun getDetailData(): ProductDetail?
}