package com.example.coin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {


    private lateinit var coinSideTextView: TextView
    private lateinit var flipButton: Button
    private lateinit var resetButton: Button
    private lateinit var headsCountTextView: TextView
    private lateinit var tailsCountTextView: TextView



    private var headsCount: Int = 0
    private var tailsCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinSideTextView = findViewById(R.id.coinSideTextView)
        flipButton = findViewById(R.id.flipButton)
        resetButton = findViewById(R.id.resetButton)
        headsCountTextView = findViewById(R.id.headsCountTextView)
        tailsCountTextView = findViewById(R.id.tailsCountTextView)
        flipButton.setOnClickListener { flipCoin() }
        resetButton.setOnClickListener { resetCounts() }

    }

    private fun flipCoin() {
        var numOfFlips = findViewById<EditText>(R.id.editTextNumber)
        var fl: Int = numOfFlips.text.toString().toInt()

            for (i in 1..fl) {
                val random = Random().nextInt(2)
                if (random == 0) {
                    coinSideTextView.text = "Heads"
                    headsCount++
                    headsCountTextView.text = "Heads Count: $headsCount"
                } else {
                    coinSideTextView.text = "Tails"
                    tailsCount++
                    tailsCountTextView.text = "Tails Count: $tailsCount"
                }
            }


    }


    private fun resetCounts() {
        headsCount = 0
        tailsCount = 0
        headsCountTextView.text = "Heads Count: $headsCount"
        tailsCountTextView.text = "Tails Count: $tailsCount"
    }
}
