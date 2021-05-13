package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    val currentScrambleWord : String get() = _currentScrambledWord

    private var _count = 0
    val count : Int get() = _count

    fun getNextWord(){
        val currentWord = allWordsList.random()
        val scrambledWord = currentWord.toCharArray()
        _currentScrambledWord = String(scrambledWord)
    }
}