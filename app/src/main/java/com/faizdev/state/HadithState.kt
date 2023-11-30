package com.faizdev.state

import com.faizdev.ourhadith.models.HadithResponse

sealed class HadithState {
    object Loading : HadithState()
    data class Error(val message: String) : HadithState()
    data class Success(val list: HadithResponse) : HadithState()
}