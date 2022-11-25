package com.sopt.soptmon.api.food

import retrofit2.Call
import retrofit2.http.GET

interface BestItemService {
    @GET("best-item")
    fun getBestItem(): Call<ResponseBestItemDto>
}