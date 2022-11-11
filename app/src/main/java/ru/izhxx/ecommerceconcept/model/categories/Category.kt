package ru.izhxx.ecommerceconcept.model.categories

import ru.izhxx.domain.impl.entities.delegate.CategoryDelegate

data class Category(
    override var id: Int,
    val name: String,
    val iconId: Int,
    var isClicked: Boolean
): CategoryDelegate