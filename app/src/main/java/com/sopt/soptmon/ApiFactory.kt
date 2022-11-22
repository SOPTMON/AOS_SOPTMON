package com.sopt.soptmon

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.soptmon.daehwan.HomeApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    val retrofit by lazy {
        ApiUrlRetrofit.BASE_SERVER.retrofit()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ApiPool {
    val HomeApi = ApiFactory.create<HomeApi>()
}

private enum class ApiUrlRetrofit(
    val retrofit: Retrofit
) {
    BASE_SERVER(
        Retrofit.Builder()
            .baseUrl("http://15.164.135.171:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    ) {
        override fun retrofit(): Retrofit = retrofit
    },

    ;

    abstract fun retrofit(): Retrofit
}