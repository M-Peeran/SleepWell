package com.peeranm.sleepwell.feature_sleep.presentation.sleeps.components

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
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.getDate
import com.peeranm.sleepwell.feature_sleep.utils.getImageRes
import com.peeranm.sleepwell.feature_sleep.utils.getQualityString
import com.peeranm.sleepwell.feature_sleep.utils.getSleepDuration

@Composable
fun SleepItem(
    modifier: Modifier = Modifier,
    sleep: Sleep,
    onRecordClick: (Long) -> Unit
) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.clickable { onRecordClick(sleep.id) },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                modifier = Modifier.size(80.dp).padding(8.dp),
                model = getImageRes(sleep.sleepQuality),
                contentDescription = "Sleep quality"
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Date : ${getDate(sleep.startTimestamp)}")
                Text(text = "Quality : ${getQualityString(sleep.sleepQuality)}")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Duration")
                Text(text = getSleepDuration(sleep.stopTimestamp - sleep.startTimestamp))
            }
            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}