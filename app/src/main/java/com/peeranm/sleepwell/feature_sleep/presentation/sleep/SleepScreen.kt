package com.peeranm.sleepwell.feature_sleep.presentation.sleep

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.peeranm.sleepwell.feature_sleep.presentation.sleep.components.LastSleep
import com.peeranm.sleepwell.feature_sleep.presentation.sleep.components.NoSleep
import com.peeranm.sleepwell.feature_sleep.presentation.sleep.components.OtherOptions
import com.peeranm.sleepwell.feature_sleep.presentation.sleep.components.RecordingSleep
import com.peeranm.sleepwell.feature_sleep.utils.Screens
import com.peeranm.sleepwell.feature_sleep.utils.SleepEvents

@Composable
fun SleepScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SleepViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()
    val sleepState = viewModel.sleepState.value
    val isRecording = sleepState.isRecording
    val isLastSleepAvailable = sleepState.lastSleep != null

    val sleepQuality = navController.currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<Int>("sleepQuality")?.observeAsState().also {
            navController.currentBackStackEntry
                ?.savedStateHandle
                ?.remove<Int>("sleepQuality")
        }

    val isSleepQualityAvailable = sleepQuality?.value != null
    LaunchedEffect(key1 = isSleepQualityAvailable) {
        if (isSleepQualityAvailable) {
            Log.d("APP_LOGS", "Quality not null")
            viewModel.onEvent(SleepEvents.StopRecording(sleepQuality?.value!!))
        }
    }

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.onEvent(SleepEvents.StartRecording) }) {
                Icon(
                    imageVector = Icons.Rounded.Bedtime,
                    contentDescription = "Add Sleep"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "WellSleep",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            when {
                isRecording -> {
                    RecordingSleep(
                        modifier = Modifier.fillMaxWidth(),
                        onStopRecordingClick = {
                            navController.navigate(Screens.SleepQualityScreen.route)
                        }
                    )
                }
                isLastSleepAvailable -> {
                    val sleep = sleepState.lastSleep!!
                    LastSleep(
                        modifier = Modifier.fillMaxWidth(),
                        sleepQuality = sleep.sleepQuality,
                        onLastSleepClick = {
                            navController.navigate(
                                Screens.SleepDetailsScreen.getRouteWithArgValues("sleepId" to sleep.id)
                            )
                        }
                    )
                }
                else -> NoSleep(modifier = Modifier.fillMaxWidth())
            }
            Spacer(modifier = Modifier.height(16.dp))
            OtherOptions(
                modifier = Modifier.fillMaxWidth(),
                onSleepRecordsClick = { navController.navigate(Screens.SleepsScreen.route) },
                onAboutClick = {  }
            )
        }
    }
}