package com.peeranm.sleepwell.feature_sleep.presentation.sleep

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.use_cases.SleepUseCases
import com.peeranm.sleepwell.feature_sleep.utils.SleepEvents
import com.peeranm.sleepwell.feature_sleep.utils.SleepState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _sleepState = mutableStateOf(SleepState())
    val sleepState: State<SleepState> = _sleepState

    init {
        viewModelScope.launch {
            val lastSleep = sleepUseCases.getLastSleep() ?: return@launch
            _sleepState.value = sleepState.value.copy(lastSleep = lastSleep)
        }
    }

    fun onEvent(event: SleepEvents) {
        when (event) {
            is SleepEvents.StartRecording -> {
                viewModelScope.launch {
                    sleepUseCases.insertSleep(
                        Sleep(startTimestamp = System.currentTimeMillis())
                    )
                    _sleepState.value = sleepState.value.copy(isRecording = true)
                }
            }
            is SleepEvents.StopRecording -> {
                viewModelScope.launch {
                    val lastSleep = sleepUseCases.getLastSleep() ?: return@launch
                    sleepUseCases.updateSleep(
                        lastSleep.copy(
                            sleepQuality = event.sleepQuality,
                            stopTimestamp = System.currentTimeMillis()
                        )
                    )
                    val newLastSleep = sleepUseCases.getLastSleep()
                    _sleepState.value = sleepState.value.copy(
                        isRecording = false,
                        lastSleep = newLastSleep
                    )
                }
            }
            is SleepEvents.DeleteAllRecords -> {
                viewModelScope.launch {
                    sleepUseCases.deleteSleeps()
                }
            }
            is SleepEvents.DeleteRecord -> {
                viewModelScope.launch {
                    sleepUseCases.deleteSleepById(event.sleepId)
                }
            }
        }
    }

}