package com.blankspace.algovis.BubbleSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blankspace.algovis.AlgoViewModel

class BubbleViewModelProvider(
    private val bubbleSort: BubbleSort
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BubbleViewModel(bubbleSort) as T
    }
}