package com.peeranm.sleepwell.feature_sleep.presentation.sleeps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.use_cases.SleepUseCases
import com.peeranm.sleepwell.feature_sleep.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SleepsViewModel @Inject constructor(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _sleepsState = mutableStateOf<DataState<List<Sleep>>>(DataState.None)
    val sleepsState: State<DataState<List<Sleep>>> = _sleepsState


    init {
        sleepUseCases.getSleepsForUi()
            .onEach { dataState -> _sleepsState.value = dataState }
            .launchIn(viewModelScope)
    }

}