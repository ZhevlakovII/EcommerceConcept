package ru.izhxx.data.datasources.impl

import android.util.Log
import ru.izhxx.data.api.CartResponse
import ru.izhxx.data.datasources.api.CartDataSource
import ru.izhxx.data.mappers.CartEntityMapper
import ru.izhxx.domain.impl.entities.UserBasket

class CartDataSourceImpl(
    private val cartResponse: CartResponse,
    private val mapper: CartEntityMapper
): CartDataSource {
    override suspend fun getCartData(): UserBasket? {
        return try {
            val cartData = cartResponse.getCartData()
            mapper.toUserBasket(cartData)
        } catch (e: Exception) {
            Log.d(TAG, e.message!!)
            null
        }
    }

    companion object {
        const val TAG = "CartDS"
    }
}