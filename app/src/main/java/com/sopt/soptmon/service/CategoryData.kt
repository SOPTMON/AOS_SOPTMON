package com.sopt.soptmon.service

import androidx.annotation.DrawableRes

data class CategoryData(
    @DrawableRes var image: Int,
    var name: String,
    @DrawableRes var colors: ArrayList<Int>
)
