package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var secretNumber = Random.nextInt(1, 101)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessInput = findViewById<EditText>(R.id.guessInput)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val newGameButton = findViewById<Button>(R.id.newGameButton)

        guessButton.setOnClickListener {
            val guess = guessInput.text.toString().toIntOrNull()

            if (guess == null) {
                resultText.text = "Please enter a valid number."
            } else {
                when {
                    guess < secretNumber -> resultText.text = "Too low!"
                    guess > secretNumber -> resultText.text = "Too high!"
                    else -> resultText.text = "Correct! You guessed it!"
                }
            }
        }

        newGameButton.setOnClickListener {
            secretNumber = Random.nextInt(1, 101)
            guessInput.text.clear()
            resultText.text = "Start guessing!"
        }
    }
}