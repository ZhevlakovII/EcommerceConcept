package ru.izhxx.domain.api.usecases

import ru.izhxx.domain.impl.entities.UserBasket

interface GetUserBasketUseCase {
    suspend fun invoke(userId: Int): UserBasket?
}