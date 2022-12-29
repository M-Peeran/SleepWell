package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetLastSleepUseCase(private val repository: SleepRepository) {

    suspend operator fun invoke(): Sleep?
    = withContext(Dispatchers.IO) { repository.getLastSleep() }
}