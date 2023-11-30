package com.faizdev.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faizdev.ourhadith.repository.HadithRepository
import com.faizdev.state.PerawiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PerawiViewModel(
    private val repository: HadithRepository
) : ViewModel() {
    private var _getPerawi = MutableStateFlow<PerawiState?>(PerawiState.Loading)
    var getPerawi = _getPerawi.asStateFlow().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        PerawiState.Loading
    )

    fun getList() {
        viewModelScope.launch {
            _getPerawi.emit(PerawiState.Loading)
            try {
                _getPerawi.emit(PerawiState.Success(repository.getPerawi()))
            } catch (e: Exception) {
                _getPerawi.emit(PerawiState.Error(e.message.toString()))
            }
        }
    }
}