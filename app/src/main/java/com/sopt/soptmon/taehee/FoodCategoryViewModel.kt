package com.dabo.soptmon_prototype

import androidx.lifecycle.ViewModel
import com.dabo.soptmon_prototype.data.FoodCategory

class FoodCategoryViewModel : ViewModel(){
    val categoryList = listOf<FoodCategory>(
        FoodCategory(
            title = "전체"
        ),
        FoodCategory(
            title = "신선식품"
        ),
        FoodCategory(
            title = "가공식품"
        ),
        FoodCategory(
            title = "건강식품/다이어트"
        ),
        FoodCategory(
            title = "커피/음료"
        )
    )
}