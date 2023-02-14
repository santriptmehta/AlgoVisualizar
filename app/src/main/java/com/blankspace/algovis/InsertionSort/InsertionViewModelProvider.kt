package com.blankspace.algovis.InsertionSort

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InsertionViewModelProvider(
    private val insertionSort: InsertionSort
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InsertionViewModel(insertionSort) as T
    }
}