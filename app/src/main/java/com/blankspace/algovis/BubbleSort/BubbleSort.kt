package com.blankspace.algovis.BubbleSort

class BubbleSort {
    suspend fun sort(
        arr : IntArray,
        onSwap : (IntArray)->Unit
    ){
        var swapped = true
        for (i in 0 until arr.size -1){
            if(!swapped) break
            swapped = false
            for (j in 0 until arr.size-i-1){
                if(arr[j] > arr[j+1]){
                    val temp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = temp
                    onSwap(arr)
                    swapped = true
                }
            }
        }
    }
}