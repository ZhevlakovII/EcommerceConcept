package ru.izhxx.domain.api.usecases

import ru.izhxx.domain.impl.entities.ProductExplorer

interface GetExplorerDataUseCase {
    suspend fun invoke(): ProductExplorer?
}