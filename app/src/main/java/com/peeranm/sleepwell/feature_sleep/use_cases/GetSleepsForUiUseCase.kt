package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSleepsForUiUseCase(private val getSleeps: GetSleepsUseCase) {

    operator fun invoke(): Flow<Resource<List<Sleep>>> = flow {
        emit(Resource.Loading)
        val sleeps = getSleeps()
        if (sleeps.isEmpty()) {
            emit(Resource.Failure("No sleep data found on the device storage"))
        } else {
            emit(Resource.Success(sleeps))
        }
    }
}