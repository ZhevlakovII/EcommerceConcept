package ru.izhxx.data.datasources.impl

import android.util.Log
import ru.izhxx.data.api.DetailsResponse
import ru.izhxx.domain.impl.entities.ProductDetail
import ru.izhxx.data.datasources.api.DetailsDataSource
import ru.izhxx.data.mappers.DetailEntityMapper

class DetailsDataSourceImpl(
    private val detailsResponse: DetailsResponse,
    private val mapper: DetailEntityMapper
): DetailsDataSource {
    override suspend fun getDetailData(): ProductDetail? {
        return try {
            val productData = detailsResponse.getDetailsData()
            return mapper.toProductDetail(productData)
        } catch (e: Exception) {
            Log.d(TAG, e.message!!)
            null
        }
    }

    companion object {
        const val TAG = "DetailsDS"
    }

}