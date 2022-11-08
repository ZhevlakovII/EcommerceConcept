package ru.izhxx.domain.impl.entities

data class ProductHot(
    val id: Int,
    val name: String,
    val description: String,
    val pictureUrl: String,
    val isNew: Boolean = false,
    val isBuy: Boolean = false
)
