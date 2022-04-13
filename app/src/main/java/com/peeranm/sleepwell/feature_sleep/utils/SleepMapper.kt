package com.peeranm.sleepwell.feature_sleep.utils

import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.model.SleepEntity

class SleepMapper : Mapper<SleepEntity, Sleep> {

    override fun toEntity(model: Sleep, shouldIgnoreId: Boolean): SleepEntity {
        return if (shouldIgnoreId) {
            SleepEntity(
                sleepQuality = model.sleepQuality,
                startTimestamp = model.startTimestamp,
                stopTimestamp = model.stopTimestamp
            )
        } else {
            SleepEntity(
                id = model.id,
                sleepQuality = model.sleepQuality,
                startTimestamp = model.startTimestamp,
                stopTimestamp = model.stopTimestamp
            )
        }
    }

    override fun fromEntity(entity: SleepEntity): Sleep {
        return Sleep(
            id = entity.id,
            sleepQuality = entity.sleepQuality,
            startTimestamp = entity.startTimestamp,
            stopTimestamp = entity.stopTimestamp
        )
    }

    fun fromEntities(entities: List<SleepEntity>): List<Sleep> {
        return entities.map { fromEntity(it) }
    }
    fun toEntities(models: List<Sleep>): List<SleepEntity> {
        return models.map { toEntity(it) }
    }

}