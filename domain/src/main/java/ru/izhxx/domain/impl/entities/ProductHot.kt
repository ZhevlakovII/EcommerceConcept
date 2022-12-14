package ru.izhxx.domain.impl.entities

import ru.izhxx.domain.impl.entities.delegate.HotDelegate

data class ProductHot(
    override var id: Int,
    val name: String,
    val description: String,
    val pictureUrl: String,
    val isNew: Boolean = false,
    val isBuy: Boolean = false
): HotDelegate
