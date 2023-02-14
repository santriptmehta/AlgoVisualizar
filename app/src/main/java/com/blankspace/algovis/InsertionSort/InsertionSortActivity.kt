package com.blankspace.algovis.InsertionSort

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.blankspace.algovis.AlgoViewModel
import com.blankspace.algovis.AlgorithmEvent
import com.blankspace.algovis.AlgorithmViewModelProvider
import com.blankspace.algovis.BubbleSort.BubbleSort
import com.blankspace.algovis.component.VisualizerSection
import com.blankspace.algovis.component.viBottomBar
import com.blankspace.algovis.ui.theme.AlgoVisTheme
import kotlinx.coroutines.launch

class InsertionSortActivity() : ComponentActivity() {
    private val viewModel: InsertionViewModel by lazy {
        val viewModelProviderFactory = InsertionViewModelProvider(InsertionSort())
        ViewModelProvider(this, viewModelProviderFactory)[InsertionViewModel::class.java]

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgoVisTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column {
                        VisualizerSection(
                            arr = viewModel.arr.value,
                            modifier = Modifier.fillMaxWidth()
                        )
                        val isPlaying = viewModel.isPlaying.value
                        val isFinished = viewModel.onSortingFinish.value

                        viBottomBar(
                            playPauseClick = { viewModel.onEvent(AlgorithmEvent.PlayPause) },
                            slowDownClick = { viewModel.onEvent(AlgorithmEvent.slowdown) },
                            speedUpClick = { viewModel.onEvent(AlgorithmEvent.SpeedUp) },
                            previousClick = { viewModel.onEvent(AlgorithmEvent.Previous) },
                            nextClick = { viewModel.onEvent(AlgorithmEvent.Next) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(75.dp),
                            isPlaying = if (isFinished) !isFinished else isPlaying

                        )
                    }
                }

            }
        }
    }
}

