package ru.izhxx.data.mappers

import android.graphics.Color
import ru.izhxx.data.entities.details.Detail
import ru.izhxx.domain.impl.entities.PhoneSpecification
import ru.izhxx.domain.impl.entities.ProductDetail

class DetailEntityMapper {
    fun toProductDetail(product: Detail): ProductDetail {
        return ProductDetail(
            id = product.id,
            name = product.title,
            price = product.price,
            rating = product.rating.toFloat(),
            isFavorite = product.isFavorite,
            pictureUrls = product.pictureUrls,
            specs = getSpecs(product)
        )
    }

    private fun getSpecs(product: Detail): PhoneSpecification {
        return PhoneSpecification(
            cpu = product.cpu,
            camera = product.camera,
            memory = product.storage,
            ram = product.ram,
            colors = getColors(product.colors),
            capacity = product.capacity
        )
    }

    private fun getColors(colors: List<String>): List<Int> {
        return colors.map { Color.parseColor(it) }
    }
}