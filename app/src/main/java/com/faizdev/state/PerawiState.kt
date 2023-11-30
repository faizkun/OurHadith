package com.faizdev.state

import com.faizdev.ourhadith.models.PerawiResponse


sealed class PerawiState {
    object Loading : PerawiState()
    data class Error(val message: String) : PerawiState()
    data class Success(val list: PerawiResponse) : PerawiState()
}