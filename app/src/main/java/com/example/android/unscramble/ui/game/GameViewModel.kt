package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){
    private var _score = 0
    val score : Int get() = _score

    private var _currentWordCount = 0
    val currentWordCount : Int get() = _currentWordCount

    private var _currentScrambledWord = "test"
    val currentScrambleWord : String get() = _currentScrambledWord

    private var usedWordsList : MutableList<String> = mutableListOf()
    private lateinit var currentWord : String

    private var _count = 0
    val count : Int get() = _count

    private fun getNextWord(){
        currentWord = allWordsList.random()
        val scrambledWord = currentWord.toCharArray()
        if(usedWordsList.contains(currentWord)){
            getNextWord()
        }else{
            scrambledWord.shuffle()
            while(scrambledWord.toString().equals(currentScrambleWord, true)){
                scrambledWord.shuffle()
            }
            _currentScrambledWord = String(scrambledWord)
            ++_currentWordCount
            usedWordsList.add(currentWord)
        }
    }
}