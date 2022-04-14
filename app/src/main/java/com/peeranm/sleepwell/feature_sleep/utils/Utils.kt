package com.peeranm.sleepwell.feature_sleep.utils

import androidx.navigation.NavController
import com.peeranm.sleepwell.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

 fun putSleepQuality(
    sleepQuality: Int,
    navController: NavController
) {
    navController.previousBackStackEntry?.savedStateHandle?.set(
        "sleepQuality", sleepQuality
    )
}

fun getImageRes(sleepQuality: Int): Int {
    return when (sleepQuality) {
        1 -> R.drawable.ic_sleep_quality_1
        2 -> R.drawable.ic_sleep_quality_2
        3 -> R.drawable.ic_sleep_quality_3
        4 -> R.drawable.ic_sleep_quality_4
        5 -> R.drawable.ic_sleep_quality_5
        6 -> R.drawable.ic_sleep_quality_6
        else -> -1
    }
}

fun getQualityString(sleepQuality: Int): String {
    return when (sleepQuality) {
        1 -> "Terrible!"
        2 -> "Unacceptable"
        3 -> "Not good"
        4 -> "OK-OK"
        5 -> "Good"
        6 -> "Excellent"
        else -> "None"
    }
}

fun getDate(timeMillis: Long): String {
    return SimpleDateFormat.getDateInstance(
        DateFormat.SHORT,
        Locale.UK
    ).format(timeMillis)
}

fun getSleepDuration(durationMillis: Long): String {
    val seconds: Long = durationMillis / 1000 % 60
    val minutes: Long = durationMillis / (1000 * 60) % 60
    val hours: Long = durationMillis / (1000 * 60 * 60) % 24
    return "${hours}h: ${minutes}m: ${seconds}s"
}