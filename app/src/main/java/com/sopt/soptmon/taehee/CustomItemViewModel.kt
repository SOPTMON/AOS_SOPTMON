package com.dabo.soptmon_prototype

import androidx.lifecycle.ViewModel
import com.dabo.soptmon_prototype.remote.ResponseCustomItemDto

class CustomItemViewModel : ViewModel() {
    val customItemList = mutableListOf<ResponseCustomItemDto.CustomItem>()

}