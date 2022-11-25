package com.dabo.soptmon_prototype

import androidx.lifecycle.ViewModel
import com.dabo.soptmon_prototype.remote.ResponseBestItemDto
import com.dabo.soptmon_prototype.remote.ResponseCustomItemDto

class BestItemViewModel : ViewModel() {
    val bestItemList = mutableListOf<ResponseBestItemDto.BestItem>()
}