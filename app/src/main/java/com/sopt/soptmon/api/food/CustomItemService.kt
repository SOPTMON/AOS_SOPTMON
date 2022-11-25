package com.sopt.soptmon.api.food

import retrofit2.Call
import retrofit2.http.GET

interface CustomItemService {
    @GET("custom")
    fun getCustomItem(): Call<ResponseCustomItemDto>
}