package com.peeranm.sleepwell.feature_sleep.use_cases

class SleepUseCases(
    val insertSleep: InsertSleepUseCase,
    val updateSleep: UpdateSleepUseCase,
    val deleteSleepById: DeleteSleepByIdUseCase,
    val deleteSleeps: DeleteSleepsUseCase,
    val getSleepById: GetSleepByIdUseCase,
    val getSleeps: GetSleepsUseCase,
    val getSleepsForUi: GetSleepsForUiUseCase,
    val getLastSleep: GetLastSleepUseCase,
)