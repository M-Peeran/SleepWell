package com.peeranm.sleepwell.feature_sleep.presentation.sleep_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.use_cases.SleepUseCases
import com.peeranm.sleepwell.feature_sleep.utils.SleepDetailsEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.internal.userAgent
import javax.inject.Inject

@HiltViewModel
class SleepDetailsViewModel @Inject constructor(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _sleepState = mutableStateOf<Sleep?>(null)
    val sleepState: State<Sleep?> = _sleepState

    init {
        viewModelScope.launch {
            val sleepId = savedStateHandle.get<Long>("sleepId")
            sleepId?.let { _sleepState.value = sleepUseCases.getSleepById(it) }
        }
    }

    fun onEvent(event: SleepDetailsEvents) {
        when (event) {
            is SleepDetailsEvents.Delete -> {
                viewModelScope.launch {
                    sleepUseCases.deleteSleepById(event.sleepId)
                }
            }
        }
    }

}