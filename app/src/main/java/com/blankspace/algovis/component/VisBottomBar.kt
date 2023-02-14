package com.blankspace.algovis.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.blankspace.algovis.R

@Composable
fun viBottomBar(
    modifier: Modifier = Modifier,
    playPauseClick: () -> Unit,
    slowDownClick: () -> Unit,
    speedUpClick: () -> Unit,
    previousClick: () -> Unit,
    nextClick: () -> Unit,
    isPlaying: Boolean = false
){
    BottomAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            IconButton(onClick = slowDownClick) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_horizontal),
                    contentDescription = "slow down",
                    tint = MaterialTheme.colors.onSurface
                )
            }
            IconButton(onClick = playPauseClick) {

                Icon(
                    painter = painterResource(id =
                     if(!isPlaying) R.drawable.ic_play else R.drawable.ic_pause
                    ),
                    contentDescription = "PlayPaush",
                    tint = Color.White
                )
            }
            IconButton(onClick = speedUpClick) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "slow Up",
                    tint = MaterialTheme.colors.onSurface
                )
            }
            IconButton(onClick = previousClick) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Previous step",
                    tint = MaterialTheme.colors.onSurface
                )
            }
            IconButton(onClick = nextClick) {

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Next Step",
                    tint = MaterialTheme.colors.onSurface
                )
            }
        }
    }

}