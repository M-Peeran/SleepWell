package com.peeranm.sleepwell.feature_sleep.utils

import com.peeranm.sleepwell.feature_sleep.model.Sleep

data class SleepState (
    val isRecording: Boolean = false,
    val lastSleep: Sleep? = null
)