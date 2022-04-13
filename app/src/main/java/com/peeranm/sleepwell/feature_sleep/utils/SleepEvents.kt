package com.peeranm.sleepwell.feature_sleep.utils


sealed class SleepEvents {
    object DeleteAllRecords : SleepEvents()
    object StartRecording : SleepEvents()
    class StopRecording(val sleepQuality: Int) : SleepEvents()
    class DeleteRecord(val sleepId: Long) : SleepEvents()
 }