package com.peeranm.sleepwell.feature_sleep.utils

sealed class FetchResult {
    object None : FetchResult()
    object Loading : FetchResult()
    object Success : FetchResult()
    class Failure(val message: String) : FetchResult()
}