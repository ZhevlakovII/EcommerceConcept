package ru.izhxx.domain.api.repositories

interface ProductRepository {
    fun getProductExplorer()

    fun getUserBasket(userId: Int)

    fun getPhoneSpecification(productId: Int)
}