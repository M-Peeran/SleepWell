package com.peeranm.sleepwell.feature_sleep.presentation.sleep.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R
import com.peeranm.sleepwell.feature_sleep.utils.getImageRes

@Composable
fun LastSleep(
    modifier: Modifier = Modifier,
    sleepQuality: Int,
    onLastSleepClick: () -> Unit
) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onLastSleepClick() }
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "How was your last sleep?")
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                modifier = Modifier.size(80.dp),
                model = getImageRes(sleepQuality),
                contentDescription = "Sleep quality"
            )
        }
    }
}