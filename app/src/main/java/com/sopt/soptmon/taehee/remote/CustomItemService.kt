package com.dabo.soptmon_prototype.remote

import retrofit2.Call
import retrofit2.http.GET

interface CustomItemService {
    @GET("custom")
    fun getCustomItem(): Call<ResponseCustomItemDto>
}