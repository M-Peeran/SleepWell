package com.peeranm.sleepwell.feature_sleep.utils


sealed class SleepDetailsEvents {
    class Delete(val sleepId: Long) : SleepDetailsEvents()
}
