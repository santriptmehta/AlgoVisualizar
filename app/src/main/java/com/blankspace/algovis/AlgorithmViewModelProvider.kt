package com.blankspace.algovis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blankspace.algovis.BubbleSort.BubbleSort
import com.blankspace.algovis.InsertionSort.InsertionSort

class AlgorithmViewModelProvider(
    private val insertionSort: InsertionSort,
    private val bubbleSort: BubbleSort
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlgoViewModel(insertionSort,bubbleSort) as T
    }
}