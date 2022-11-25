package com.sopt.soptmon.api.food

import kotlinx.serialization.Serializable

@Serializable
data class ResponseBestItemDto(
    val data: List<BestItem>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    @Serializable
    data class BestItem(
        val bestDiscountRate: Int,
        val bestItemId: Int,
        val bestItemImage: String,
        val bestItemName: String,
        val bestItemPrice: Int
    )
}