package com.peeranm.sleepwell.feature_sleep.utils

sealed class Resource<out R> {
    object None : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    class Success<T>(val data: T) : Resource<T>()
    class Failure(val message: String) : Resource<Nothing>()
}