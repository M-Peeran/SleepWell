package com.peeranm.sleepwell.feature_sleep.data.repository.impl

import com.peeranm.sleepwell.feature_sleep.data.local.dao.SleepDao
import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.SleepMapper

class SleepRepositoryImpl(
    private val sleepDao: SleepDao,
    private val sleepMapper: SleepMapper
) : SleepRepository {

    override suspend fun insertSleep(sleep: Sleep) {
        sleepDao.insertSleep(
            sleepMapper.toEntity(
                model = sleep,
                shouldIgnoreId = true
            )
        )
    }

    override suspend fun updateSleep(sleep: Sleep) {
        sleepDao.insertSleep(
            sleepMapper.toEntity(sleep)
        )
    }

    override suspend fun deleteSleepById(id: Long) {
        sleepDao.deleteSleepById(id)
    }

    override suspend fun deleteAll() {
        sleepDao.deleteAll()
    }

    override suspend fun getSleepById(id: Long): Sleep? {
        return sleepMapper.fromEntity(
            sleepDao.getSleepById(id) ?: return null
        )
    }

    override suspend fun getSleeps(): List<Sleep> {
        return sleepMapper.fromEntities(
            sleepDao.getSleeps()
        )
    }

    override suspend fun getLastSleep(): Sleep? {
        return sleepMapper.fromEntity(
            sleepDao.getLastSleep() ?: return null
        )
    }
}