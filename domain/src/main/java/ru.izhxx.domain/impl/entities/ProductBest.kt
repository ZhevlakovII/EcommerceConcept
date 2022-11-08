package ru.izhxx.domain.impl.entities

data class ProductBest(
    val id: Int,
    val name: String,
    val pictureUrl: String,
    val isFavorite: Boolean = false,
    val price: Int,
    val discountPrice: Int?,

)