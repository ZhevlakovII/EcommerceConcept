package ru.izhxx.data.datasources.api

import ru.izhxx.domain.impl.entities.UserBasket

interface CartDataSource {
    suspend fun getCartData(): UserBasket?
}