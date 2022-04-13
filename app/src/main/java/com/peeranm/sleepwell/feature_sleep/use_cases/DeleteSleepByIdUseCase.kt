package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.SleepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteSleepByIdUseCase(private val repository: SleepRepository) {

    suspend operator fun invoke(id: Long)
    = withContext(Dispatchers.IO) { repository.deleteSleepById(id) }
}