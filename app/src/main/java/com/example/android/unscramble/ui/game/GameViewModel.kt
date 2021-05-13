package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    val score: Int get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int get() = _currentWordCount

    private lateinit var _currentScrambledWord: String
    val currentScrambleWord: String get() = _currentScrambledWord

    private var usedWordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private var _count = 0
    val count: Int get() = _count

    init {
        getNextWord()
    }

    /*
     * Updates currentWord and currentScrambledWord with the next word.
     */
    private fun getNextWord() {
        currentWord = allWordsList.random()
        val scrambledWord = currentWord.toCharArray()
        _currentScrambledWord = String(scrambledWord)
        if (usedWordsList.contains(currentWord)) {
            getNextWord()
        } else {
            scrambledWord.shuffle()
            while (scrambledWord.toString().equals(currentScrambleWord, false)) {
                scrambledWord.shuffle()
            }
            _currentScrambledWord = String(scrambledWord)
            ++_currentWordCount
            usedWordsList.add(currentWord)
        }
    }

    private fun increaseScore(){
        _score += SCORE_INCREASE
    }
    /*
     * Returns true if the current word count is less than MAX_NO_OF_WORDS.
     * Updates the next word.
     */
    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else {
            false
        }
    }
}