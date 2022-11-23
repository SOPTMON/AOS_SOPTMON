package com.sopt.soptmon.daehwan

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.Call
import retrofit2.http.GET

interface HomeApi {
    @GET("custom")
    fun getSuggestions(): Call<HomeSuggestionResponse>

    @GET("live")
    fun getTvOns(): Call<TvOnResponse>
}

interface HomeResponse {
    fun isSuccessful(): Boolean
    fun getBody(): List<Any>?
}

@Serializable
data class HomeSuggestionResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<SuggestionDetail>?
) : HomeResponse {
    override fun isSuccessful() = status.toString().startsWith("2")
    override fun getBody(): List<Any>? = data

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

@Serializable
data class TvOnResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<TvOnDetail>?
) : HomeResponse {
    override fun isSuccessful() = status.toString().startsWith("2")
    override fun getBody(): List<Any>? = data
}

@Serializable
data class TvOnDetail(
    @SerialName("liveId")
    val id: Int,
    @SerialName("liveName")
    val name: String,
    @SerialName("liveImage")
    val imageUrl: String
)