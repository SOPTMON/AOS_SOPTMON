package com.sopt.soptmon.api.food

import androidx.lifecycle.ViewModel

class BestItemViewModel : ViewModel() {
    val bestItemList = mutableListOf<ResponseBestItemDto.BestItem>()
}