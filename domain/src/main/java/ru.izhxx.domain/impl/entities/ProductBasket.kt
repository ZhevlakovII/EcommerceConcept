package ru.izhxx.domain.impl.entities

data class ProductBasket(
    val id: Int,
    val name: String,
    val pictureUrl: String,
    val price: Int,
    val count: Int,
    val fullPrice: Int = price * count
)
