package com.blankspace.algovis

sealed class AlgorithmEvent {
    object slowdown : AlgorithmEvent()
    object PlayPause : AlgorithmEvent()
    object SpeedUp : AlgorithmEvent()
    object Previous : AlgorithmEvent()
    object Next: AlgorithmEvent()
}