package ru.izhxx.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.izhxx.data.entities.cart.Cart

interface CartResponse {
    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartData(): Cart

    companion object {
        fun create(url: String): CartResponse {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CartResponse::class.java)
        }
    }
}