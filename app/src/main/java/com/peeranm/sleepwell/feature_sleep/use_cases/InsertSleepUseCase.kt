package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InsertSleepUseCase(private val repository: SleepRepository) {

    suspend operator fun invoke(sleep: Sleep)
    = withContext(Dispatchers.IO) { repository.insertSleep(sleep) }
}