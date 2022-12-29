package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSleepByIdUseCase(private val repository: SleepRepository) {

    suspend operator fun invoke(id: Long): Sleep?
    = withContext(Dispatchers.IO) { repository.getSleepById(id) }
}