package com.dabo.soptmon_prototype.remote

import kotlinx.serialization.Serializable

@Serializable
data class ResponseCustomItemDto(
    val data: List<CustomItem>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    @Serializable
    data class CustomItem(
        val discountRate: Int,
        val itemId: Int,
        val itemImage: String,
        val itemName: String,
        val itemPrice: Int
    )
}