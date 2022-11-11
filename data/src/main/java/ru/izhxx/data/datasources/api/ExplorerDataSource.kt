package ru.izhxx.data.datasources.api

import ru.izhxx.domain.impl.entities.ProductExplorer

interface ExplorerDataSource {
    suspend fun getExplorerData(): ProductExplorer?
}