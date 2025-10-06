package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val flashcards = listOf(
        "Capital of France?" to "Paris",
        "5 + 7 = ?" to "12",
        "Android language?" to "Kotlin",
        "Largest planet?" to "Jupiter"
    )

    private var currentIndex = 0
    private var showingQuestion = true

    private lateinit var flashcardText: TextView
    private lateinit var flipButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashcardText = findViewById(R.id.flashcard_text)
        flipButton = findViewById(R.id.flip_button)
        nextButton = findViewById(R.id.next_button)

        showQuestion()

        flipButton.setOnClickListener {
            if (showingQuestion) {
                showAnswer()
            } else {
                showQuestion()
            }
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % flashcards.size
            showQuestion()
        }
    }

    private fun showQuestion() {
        flashcardText.text = flashcards[currentIndex].first
        showingQuestion = true
    }

    private fun showAnswer() {
        flashcardText.text = flashcards[currentIndex].second
        showingQuestion = false
    }
}
