package com.peeranm.sleepwell.di

import android.app.Application
import androidx.room.Room
import com.peeranm.sleepwell.feature_sleep.data.local.SleepDatabase
import com.peeranm.sleepwell.feature_sleep.data.repository.SleepRepository
import com.peeranm.sleepwell.feature_sleep.data.repository.impl.SleepRepositoryImpl
import com.peeranm.sleepwell.feature_sleep.use_cases.*
import com.peeranm.sleepwell.feature_sleep.utils.SleepMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Application): SleepDatabase {
        val databaseBuilder = Room.databaseBuilder(
            context,
            SleepDatabase::class.java,
            "well_sleep_database"
        )
        return databaseBuilder
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUseCases(database: SleepDatabase): SleepUseCases {
        val repository: SleepRepository = SleepRepositoryImpl(
            sleepDao = database.getSleepDao(),
            sleepMapper = SleepMapper()
        )
        val getSleepsUseCase = GetSleepsUseCase(repository)
        return SleepUseCases(
            insertSleep = InsertSleepUseCase(repository),
            updateSleep = UpdateSleepUseCase(repository),
            deleteSleepById = DeleteSleepByIdUseCase(repository),
            deleteSleeps = DeleteSleepsUseCase(repository),
            getSleepById = GetSleepByIdUseCase(repository),
            getSleeps = getSleepsUseCase,
            getLastSleep = GetLastSleepUseCase(repository),
            getSleepsForUi = GetSleepsForUiUseCase(getSleepsUseCase)
        )
    }

}