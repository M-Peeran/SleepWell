package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class GetSleepsUseCase(private val sleepRepository: SleepRepository) {

    suspend operator fun invoke(): List<Sleep>
    = withContext(Dispatchers.IO) { sleepRepository.getSleeps() }
}