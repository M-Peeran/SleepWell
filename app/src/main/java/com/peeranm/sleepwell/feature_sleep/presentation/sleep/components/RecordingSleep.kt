package com.peeranm.sleepwell.feature_sleep.presentation.sleep.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R

@Composable
fun RecordingSleep(
    modifier: Modifier = Modifier,
    onStopRecordingClick: () -> Unit
) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "I'm feeling sleepy...")
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                modifier = Modifier.size(80.dp),
                model = R.drawable.ic_sleep_time,
                contentDescription = "Sleep quality"
            )
            Spacer(modifier = modifier.height(8.dp))
            Button(onClick = { onStopRecordingClick() }) {
                Text(text = "Stop")
            }
        }
    }
}