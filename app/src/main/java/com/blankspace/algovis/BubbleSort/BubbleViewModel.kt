package com.blankspace.algovis.BubbleSort

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankspace.algovis.AlgorithmEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BubbleViewModel(
    private val bubbleSort: BubbleSort
):ViewModel() {
    var arr = mutableStateOf(
        intArrayOf(
            20, 60, 90, 80, 120, 190, 70, 200, 240, 260, 300, 140, 160, 180, 10,500 , 40, 100, 5,
            50, 60, 70, 80, 130, 140, 310, 360, 340, 350, 380
        )
    )

    val isPlaying = mutableStateOf(false)
    val onSortingFinish = mutableStateOf(false)
    private var delay = 150L
    private var paush = false
    private var sortedArrayList = mutableListOf<List<Int>>()
    private var next = 1
    private var previous = 0
    init {
        viewModelScope.launch {
            bubbleSort.sort(
                arr.value.clone()
            ){ modifiedArray ->
                sortedArrayList.add(modifiedArray.toMutableList())
            }
        }
    }

    fun onEvent(event: AlgorithmEvent){
        when(event){
            is AlgorithmEvent.PlayPause->{
                playPauseAlgorithm()
            }
            is AlgorithmEvent.slowdown ->{
                slowDown()
            }
            is AlgorithmEvent.SpeedUp ->{
                speedUp()
            }
            is AlgorithmEvent.Previous ->{
                previous()
            }
            is AlgorithmEvent.Next ->{
                next()
            }
        }
    }

    private fun next() {
        if(next < sortedArrayList.size){
            arr.value = sortedArrayList[next].toIntArray()
            next++
            previous++
        }
    }

    private fun previous() {
        if(previous >= 0){
            arr.value = sortedArrayList[previous].toIntArray()
            next--
            previous--
        }
    }

    private fun speedUp() {
        delay += 100
    }

    private fun slowDown() {
        if(delay >= 150L){
            delay -= 50
        }
    }

    private fun playPauseAlgorithm() {
        if(isPlaying.value)
            paush()
        else
            play()
        isPlaying.value = !isPlaying.value

    }

    private var sortingState = 0
    private fun play() = viewModelScope.launch {
        paush = false
        for (i in 0 until sortedArrayList.size){
            if(!paush){
                delay(delay)
                arr.value = sortedArrayList[i].toIntArray()
            }
            else{
                sortingState = i
                next = i + 1
                previous = i
                return@launch
            }
        }
        onSortingFinish.value = true
    }

    private fun paush() {
        paush = true
    }
}