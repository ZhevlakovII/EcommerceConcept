package ru.izhxx.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.izhxx.data.entities.details.Detail

interface DetailsResponse {
    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailsData(): Detail

    companion object {
        fun create(url: String): DetailsResponse {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DetailsResponse::class.java)
        }
    }
}