package com.peeranm.sleepwell.feature_sleep.utils

import com.peeranm.sleepwell.feature_sleep.model.Sleep

sealed class SleepsEvents {
    class DeleteSleep(val sleep: Sleep) : SleepsEvents()
}