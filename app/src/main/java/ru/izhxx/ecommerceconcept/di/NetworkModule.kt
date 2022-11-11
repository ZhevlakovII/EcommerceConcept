package ru.izhxx.ecommerceconcept.di

import org.koin.dsl.module
import ru.izhxx.data.api.CartResponse
import ru.izhxx.data.api.DetailsResponse
import ru.izhxx.data.api.ExplorerResponse
import ru.izhxx.ecommerceconcept.BuildConfig.BASE_URL

val networkModule = module {
    single<CartResponse> { CartResponse.create(BASE_URL) }
    single<DetailsResponse> { DetailsResponse.create(BASE_URL) }
    single<ExplorerResponse> { ExplorerResponse.create(BASE_URL) }
}