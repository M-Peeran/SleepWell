package com.peeranm.sleepwell.feature_sleep.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peeranm.sleepwell.feature_sleep.data.local.entity.SleepEntity

@Dao
interface SleepDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSleep(sleep: SleepEntity)

    @Query("delete from table_sleep where id =:id")
    suspend fun deleteSleepById(id: Long)

    @Query("delete from table_sleep")
    suspend fun deleteAll()

    @Query("select * from table_sleep where id =:id")
    suspend fun getSleepById(id: Long): SleepEntity?

    @Query("select * from table_sleep order by id desc")
    suspend fun getSleeps(): List<SleepEntity>

    @Query("select * from table_sleep order by id desc limit 1")
    suspend fun getLastSleep(): SleepEntity?


}