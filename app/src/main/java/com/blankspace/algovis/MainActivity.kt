package com.blankspace.algovis

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.blankspace.algovis.BubbleSort.BubbleSortActivity
import com.blankspace.algovis.InsertionSort.InsertionSortActivity
import com.blankspace.algovis.ui.theme.AlgoVisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoVisTheme {
                val context = LocalContext.current
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize(Alignment.Center),

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(onClick = {
                        context.startActivity(Intent(context, BubbleSortActivity::class.java))
                    }) {
                        Text(text = "Bubble Sort")
                    }
                    Spacer(modifier = Modifier.height(64.dp))
                    Button(onClick = {
                        context.startActivity(Intent(context, InsertionSortActivity::class.java))
                    }) {
                        Text(text = "Insertion Sort")
                    }

                }
            }
        }
    }
}
