package com.sopt.soptmon.daeun.data

import androidx.annotation.DrawableRes

data class CategoryData(
    @DrawableRes var image: Int,
    var name: String,
    @DrawableRes var colors: ArrayList<Int>
)
