package com.peeranm.sleepwell.feature_sleep.utils

sealed class Screens(val route: String) {

    fun getRouteWithArgRefs(vararg argNames: String): String {
        return buildString {
            append(route)
            if (argNames.isNotEmpty()) {
                append("?")
                argNames.forEach { argName ->
                    append(argName)
                    append("=")
                    append("{")
                    append(argName)
                    append("}")
                    if (argName != argNames.last()) { append("&") }
                }
            }
        }
    }

    fun <T> getRouteWithArgValues(vararg argNameValuePairs: Pair<String, T>): String {
        return buildString {
            append(route)
            if (argNameValuePairs.isNotEmpty()) {
                append("?")
                argNameValuePairs.forEach { argValuePair ->
                    val (argName, argValue) = argValuePair
                    append(argName)
                    append("=")
                    append(argValue)
                    if (argValuePair != argNameValuePairs.last()) { append("&") }
                }
            }
        }
    }

    object SleepScreen : Screens("screen_sleep")
    object SleepsScreen : Screens("screen_sleeps")
    object SleepDetailsScreen : Screens("screen_sleep_details")
    object SleepQualityScreen : Screens("screen_sleep_quality")
    object AboutScreen: Screens("screen_about")
}