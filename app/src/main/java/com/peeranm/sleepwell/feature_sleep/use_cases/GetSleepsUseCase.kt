package com.peeranm.sleepwell.feature_sleep.use_cases

import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSleepsUseCase(private val sleepRepository: SleepRepository) {

    suspend operator fun invoke(): List<Sleep>
    = withContext(Dispatchers.IO) { sleepRepository.getSleeps() }
}