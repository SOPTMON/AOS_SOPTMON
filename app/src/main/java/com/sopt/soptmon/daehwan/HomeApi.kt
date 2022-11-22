package com.sopt.soptmon.daehwan

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.GET

interface HomeApi {
    @GET("custom")
    fun getSuggestions(): Call<HomeSuggestionResponse>
}

@Serializable
data class HomeSuggestionResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<SuggestionDetail>?
) {
    fun isSuccessful() = status.toString().startsWith("2")
}

@Serializable
data class SuggestionDetail(
    @SerialName("itemId")
    val id: Int,
    @SerialName("itemName")
    val name: String,
    @SerialName("itemPrice")
    val price: Int,
    @SerialName("discountRate")
    val discountRate: Int,
    @SerialName("itemImage")
    val imageUrl: String
)