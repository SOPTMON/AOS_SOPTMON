package com.sopt.soptmon.api.food

import androidx.lifecycle.ViewModel

class CustomItemViewModel : ViewModel() {
    val customItemList = mutableListOf<ResponseCustomItemDto.CustomItem>()

}