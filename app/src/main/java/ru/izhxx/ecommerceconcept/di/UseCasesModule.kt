package ru.izhxx.ecommerceconcept.di

import org.koin.dsl.module
import ru.izhxx.domain.api.usecases.GetExplorerDataUseCase
import ru.izhxx.domain.api.usecases.GetProductDetailUseCase
import ru.izhxx.domain.api.usecases.GetUserBasketUseCase
import ru.izhxx.domain.impl.usecases.GetExplorerDataUseCaseImpl
import ru.izhxx.domain.impl.usecases.GetProductDetailUseCaseImpl
import ru.izhxx.domain.impl.usecases.GetUserBasketUseCaseImpl

val useCasesModule = module {
    factory<GetExplorerDataUseCase> { GetExplorerDataUseCaseImpl(productRepository = get()) }

    factory<GetProductDetailUseCase> { GetProductDetailUseCaseImpl(productRepository = get()) }

    factory<GetUserBasketUseCase> { GetUserBasketUseCaseImpl(productRepository = get()) }
}