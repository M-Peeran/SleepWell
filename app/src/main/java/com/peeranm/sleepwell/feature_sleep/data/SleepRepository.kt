package com.peeranm.sleepwell.feature_sleep.data

import com.peeranm.sleepwell.feature_sleep.model.Sleep

interface SleepRepository {

    suspend fun insertSleep(sleep: Sleep)

    suspend fun updateSleep(sleep: Sleep)

    suspend fun deleteSleepById(id: Long)

    suspend fun deleteAll()

    suspend fun getSleepById(id: Long): Sleep?

    suspend fun getSleeps(): List<Sleep>

    suspend fun getLastSleep(): Sleep?

}