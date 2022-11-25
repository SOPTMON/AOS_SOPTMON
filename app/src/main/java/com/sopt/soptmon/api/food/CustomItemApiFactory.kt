package com.sopt.soptmon.api.food

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object CustomItemApiFactory {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://15.164.135.171:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(getOkHttpClient())
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java) //서버통신 해주는 친구

    private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(
            // 로깅 인턴셉터 추가
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )
        .build()
}

object CustomItemServicePool {
    val customItemService = CustomItemApiFactory.create<CustomItemService>()
}