package com.faizdev.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.faizdev.ourhadith.pages.HadithListScreenNavArgs
import com.faizdev.ourhadith.pages.navArgs
import com.faizdev.ourhadith.repository.HadithRepository
import com.faizdev.state.HadithState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HadithViewModel(
    repository: HadithRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val slugName = savedStateHandle.navArgs<HadithListScreenNavArgs>(). perawi

    var perawiName by mutableStateOf("")
        private set


    val hadithList = repository.getHadith(
        perawiSlugName = slugName,
        perawiName ={
            perawiName = it
        }
    ).cachedIn(viewModelScope)


}