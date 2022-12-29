package com.peeranm.sleepwell.feature_sleep.presentation.sleeps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.use_cases.SleepUseCases
import com.peeranm.sleepwell.feature_sleep.utils.Resource
import com.peeranm.sleepwell.feature_sleep.utils.FetchResult
import com.peeranm.sleepwell.feature_sleep.utils.SleepsEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import javax.inject.Inject

@HiltViewModel
class SleepsViewModel @Inject constructor(
    private val sleepUseCases: SleepUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _fetchResultState = mutableStateOf<FetchResult>(FetchResult.None)
    val fetchResultState: State<FetchResult> = _fetchResultState

    private val _sleeps = mutableStateListOf<Sleep>()
    val sleeps: List<Sleep>
    get() = _sleeps.toImmutableList()

    fun onEvent(event: SleepsEvents) {
        when (event) {
            is SleepsEvents.DeleteSleep -> {
                viewModelScope.launch {
                    sleepUseCases.deleteSleepById(event.sleep.id)
                    _sleeps.remove(event.sleep)
                    if (_sleeps.isEmpty()) {
                        _fetchResultState.value = FetchResult.Failure(
                            "No sleep data found on the device storage"
                        )
                    }
                }
            }
        }
    }

    init {
        sleepUseCases.getSleepsForUi()
            .onEach { dataState ->
                when (dataState) {
                    is Resource.None -> _fetchResultState.value = FetchResult.None
                    is Resource.Loading -> _fetchResultState.value = FetchResult.Loading
                    is Resource.Failure -> _fetchResultState.value = FetchResult.Failure(dataState.message)
                    is Resource.Success -> {
                        _fetchResultState.value = FetchResult.None
                        _sleeps.addAll(dataState.data)
                    }
                }
            }.launchIn(viewModelScope)
    }

}