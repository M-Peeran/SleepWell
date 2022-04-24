package com.peeranm.sleepwell.feature_sleep.presentation.sleeps

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.peeranm.sleepwell.feature_sleep.presentation.sleeps.components.SleepItem
import com.peeranm.sleepwell.feature_sleep.utils.FetchResult
import com.peeranm.sleepwell.feature_sleep.utils.Screens
import com.peeranm.sleepwell.feature_sleep.utils.SleepsEvents

@Composable
fun SleepsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SleepsViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val fetchResultState = viewModel.fetchResultState.value
    val sleeps = viewModel.sleeps

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "Sleep Records",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            when (fetchResultState) {
                is FetchResult.Failure -> {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) { Text(text = fetchResultState.message) }
                }
                is FetchResult.Loading -> {
                    CircularProgressIndicator()
                }
                is FetchResult.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(sleeps) { sleep ->
                            if (sleep.stopTimestamp != -1L) {
                                SleepItem(
                                    modifier = Modifier.fillMaxWidth(),
                                    sleep = sleep,
                                    onDeleteSleepCLick = { viewModel.onEvent(SleepsEvents.DeleteSleep(sleep)) },
                                    onRecordClick = {
                                        navController.navigate(
                                            Screens.SleepDetailsScreen.getRouteWithArgValues("sleepId" to sleep.id)
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
                else -> {}
            }
        }
    }

}