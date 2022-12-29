package com.peeranm.sleepwell.feature_sleep.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.peeranm.sleepwell.feature_sleep.data.local.dao.SleepDao
import com.peeranm.sleepwell.feature_sleep.data.local.entity.SleepEntity

@Database(entities = [SleepEntity::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {
    abstract fun getSleepDao(): SleepDao
}