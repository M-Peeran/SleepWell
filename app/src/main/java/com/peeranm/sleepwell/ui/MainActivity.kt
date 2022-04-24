package com.peeranm.sleepwell.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.peeranm.sleepwell.feature_sleep.presentation.about.AboutScreen
import com.peeranm.sleepwell.feature_sleep.presentation.sleep.SleepScreen
import com.peeranm.sleepwell.feature_sleep.presentation.sleep_details.SleepDetailsScreen
import com.peeranm.sleepwell.feature_sleep.presentation.sleep_quality.SleepQualityScreen
import com.peeranm.sleepwell.feature_sleep.presentation.sleeps.SleepsScreen
import com.peeranm.sleepwell.feature_sleep.utils.Screens
import com.peeranm.sleepwell.ui.theme.SleepWellTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SleepWellTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.SleepScreen.route
                    ) {
                        composable(
                            route = Screens.SleepScreen.route,
                        ) {
                            SleepScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        composable(route = Screens.SleepsScreen.route) {
                            SleepsScreen(navController = navController)
                        }
                        composable(
                            route = Screens.SleepDetailsScreen.getRouteWithArgRefs("sleepId"),
                            arguments = listOf(
                                navArgument(name = "sleepId") {
                                    type = NavType.LongType
                                    defaultValue = -1L
                                    nullable = false
                                }
                            )
                        ) { SleepDetailsScreen(navController = navController) }
                        composable(route = Screens.SleepQualityScreen.route) {
                            SleepQualityScreen(navController = navController)
                        }
                        composable(route = Screens.AboutScreen.route) {
                            AboutScreen(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SleepWellTheme {

    }
}