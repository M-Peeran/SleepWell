package com.peeranm.sleepwell.feature_sleep.presentation.sleep_quality

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R
import com.peeranm.sleepwell.feature_sleep.utils.putSleepQuality

@Composable
fun SleepQualityScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState
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
                text = "Select Sleep Quality",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(1, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_1,
                    contentDescription = "Sleep quality 1"
                )
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(2, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_2,
                    contentDescription = "Sleep quality 2"
                )
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(3, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_3,
                    contentDescription = "Sleep quality 3"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(4, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_4,
                    contentDescription = "Sleep quality 4"
                )
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(5, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_5,
                    contentDescription = "Sleep quality 5"
                )
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            putSleepQuality(6, navController)
                            navController.popBackStack()
                            navController.navigateUp()
                        },
                    model = R.drawable.ic_sleep_quality_6,
                    contentDescription = "Sleep quality 6"
                )
            }
        }
    }
}

