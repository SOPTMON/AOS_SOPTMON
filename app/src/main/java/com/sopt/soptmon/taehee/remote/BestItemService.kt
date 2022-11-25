package com.dabo.soptmon_prototype.remote

import retrofit2.Call
import retrofit2.http.GET

interface BestItemService {
    @GET("best-item")
    fun getBestItem(): Call<ResponseBestItemDto>
}