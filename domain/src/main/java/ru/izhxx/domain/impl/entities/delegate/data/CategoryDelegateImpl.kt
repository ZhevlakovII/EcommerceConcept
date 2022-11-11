package ru.izhxx.domain.impl.entities.delegate.data

import ru.izhxx.domain.impl.entities.delegate.CategoryDelegate

data class CategoryDelegateImpl(
    override val id: Int,
    var categoryData: List<CategoryDelegate>
): CategoryDelegate