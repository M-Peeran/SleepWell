package com.peeranm.sleepwell.feature_sleep.utils

sealed class DataState<out R> {
    object None : DataState<Nothing>()
    object Loading : DataState<Nothing>()
    class Success<T>(val data: T) : DataState<T>()
    class Failure(val message: String) : DataState<Nothing>()
}