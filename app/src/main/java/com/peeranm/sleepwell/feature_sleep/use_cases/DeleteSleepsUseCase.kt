package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteSleepsUseCase(private val repository: SleepRepository) {

    suspend operator fun invoke()
    = withContext(Dispatchers.IO) { repository.deleteAll() }
}