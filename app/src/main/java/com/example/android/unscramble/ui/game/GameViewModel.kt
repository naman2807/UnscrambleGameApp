package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    private var score = 0
    private var currentWordCount = 0
    private var currentScrambledWord = "test"

    private var _count = 0
    val count : Int get() = _count
}