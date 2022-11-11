package ru.izhxx.data.datasources.impl

import android.util.Log
import ru.izhxx.data.api.ExplorerResponse
import ru.izhxx.data.datasources.api.ExplorerDataSource
import ru.izhxx.data.mappers.ExplorerEntityMapper
import ru.izhxx.domain.impl.entities.ProductExplorer

class ExplorerDataSourceImpl (
    private val explorerResponse: ExplorerResponse,
    private val mapper: ExplorerEntityMapper
): ExplorerDataSource {
    override suspend fun getExplorerData(): ProductExplorer? {
        return try {
            val productData = explorerResponse.getExplorerData()
            mapper.toProductExplorer(productData)
        } catch (e: Exception) {
            Log.d(TAG, e.message!!)
            null
        }
    }

    companion object {
        const val TAG = "DetailsDS"
    }

}