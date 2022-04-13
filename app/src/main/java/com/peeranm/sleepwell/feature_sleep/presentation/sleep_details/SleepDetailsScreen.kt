package com.peeranm.sleepwell.feature_sleep.presentation.sleep_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

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
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "Sleep Records",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(16.dp))
                AsyncImage(
                    modifier = Modifier.size(80.dp),
                    model = "",
                    contentDescription = "Sleep quality"
                )
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