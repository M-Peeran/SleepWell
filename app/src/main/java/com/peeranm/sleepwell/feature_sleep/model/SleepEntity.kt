package com.peeranm.sleepwell.feature_sleep.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_sleep")
data class SleepEntity(
    val sleepQuality: Int = -1,
    val startTimestamp: Long = -1,
    val stopTimestamp: Long = -1,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
)