package com.peeranm.sleepwell.feature_sleep.presentation.sleep_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R
import com.peeranm.sleepwell.feature_sleep.utils.*

@Composable
fun SleepDetailsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SleepDetailsViewModel = hiltViewModel()
) {
    val sleep = viewModel.sleepState.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = modifier.padding(8.dp),
        scaffoldState = scaffoldState
    ) {
        if (sleep != null) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        text = "Sleep Details",
                        style = MaterialTheme.typography.h5
                    )
                    IconButton(
                        onClick = {
                            viewModel.onEvent(SleepDetailsEvents.Delete(sleep.id))
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.MoreVert,
                            contentDescription = "Delete sleep item"
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
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