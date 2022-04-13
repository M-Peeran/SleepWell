package com.peeranm.sleepwell.feature_sleep.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.peeranm.sleepwell.feature_sleep.model.SleepEntity

@Database(entities = [SleepEntity::class], version = 1, exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {
    abstract fun getSleepDao(): SleepDao
}