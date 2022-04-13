package com.peeranm.sleepwell.feature_sleep.model

data class Sleep(
    val id: Long = 0L,
    val sleepQuality: Int = -1,
    val startTimestamp: Long = -1,
    val stopTimestamp: Long = -1
)