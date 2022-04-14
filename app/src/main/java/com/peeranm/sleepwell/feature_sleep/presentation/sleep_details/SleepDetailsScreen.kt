package com.peeranm.sleepwell.feature_sleep.presentation.sleep_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R
import com.peeranm.sleepwell.feature_sleep.utils.getDate
import com.peeranm.sleepwell.feature_sleep.utils.getImageRes
import com.peeranm.sleepwell.feature_sleep.utils.getQualityString
import com.peeranm.sleepwell.feature_sleep.utils.getSleepDuration

@Composable
fun SleepDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: SleepDetailsViewModel = hiltViewModel()
) {
    val sleep = viewModel.sleepState.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState
    ) {
        if (sleep != null) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "Sleep Details",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        AsyncImage(
                            modifier = Modifier.size(100.dp),
                            model = getImageRes(sleep.sleepQuality),
                            contentDescription = "Sleep quality"
                        )
                        Spacer(modifier = modifier.height(16.dp))
                        Column (
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = "Date : ${getDate(sleep.startTimestamp)}")
                            Spacer(modifier = modifier.height(16.dp))
                            Text(text = "Quality : ${getQualityString(sleep.sleepQuality)}")
                            Spacer(modifier = modifier.height(16.dp))
                            Text(text = "Duration : ${getSleepDuration(sleep.stopTimestamp - sleep.startTimestamp)}")
                        }
                        Spacer(modifier = modifier.height(16.dp))
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Invalid sleep data found!")
            }
        }
    }
}