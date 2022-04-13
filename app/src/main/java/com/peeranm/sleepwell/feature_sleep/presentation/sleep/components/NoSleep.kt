package com.peeranm.sleepwell.feature_sleep.presentation.sleep.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.peeranm.sleepwell.R

@Composable
fun NoSleep(modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RoundedCornerShape(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Welcome!")
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                modifier = Modifier.size(80.dp),
                model = R.drawable.ic_sleep_icon,
                contentDescription = "Fresh start"
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}