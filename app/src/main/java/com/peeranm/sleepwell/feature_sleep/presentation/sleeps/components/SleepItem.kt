package com.peeranm.sleepwell.feature_sleep.presentation.sleeps.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.peeranm.sleepwell.feature_sleep.model.Sleep
import com.peeranm.sleepwell.feature_sleep.utils.getDate
import com.peeranm.sleepwell.feature_sleep.utils.getImageRes
import com.peeranm.sleepwell.feature_sleep.utils.getQualityString
import com.peeranm.sleepwell.feature_sleep.utils.getSleepDuration

@Composable
fun SleepItem(
    modifier: Modifier = Modifier,
    sleep: Sleep,
    onDeleteSleepCLick: (Long) -> Unit,
    onRecordClick: (Long) -> Unit
) {
    val expandedState = remember { mutableStateOf(false) }
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
                modifier = Modifier
                    .size(88.dp)
                    .padding(8.dp),
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
            IconButton(onClick = { expandedState.value = true }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "Options for sleep item"
                )
                DropdownMenu(
                    expanded = expandedState.value,
                    onDismissRequest = { expandedState.value = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            expandedState.value = false
                            onDeleteSleepCLick(sleep.id)
                        }
                    ) { Text(text = "Delete") }
                }
            }
        }
    }
}