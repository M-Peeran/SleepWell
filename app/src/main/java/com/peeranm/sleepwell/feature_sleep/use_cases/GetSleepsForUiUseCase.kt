package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSleepsForUiUseCase(private val getSleeps: GetSleepsUseCase) {

    operator fun invoke(): Flow<DataState<List<Sleep>>> = flow {
        emit(DataState.Loading)
        val sleeps = getSleeps()
        if (sleeps.isEmpty()) {
            emit(DataState.Failure("No sleep data found on the device storage"))
        } else {
            emit(DataState.Success(sleeps))
        }
    }
}