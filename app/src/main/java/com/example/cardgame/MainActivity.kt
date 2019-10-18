package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val diceGif = findViewById<ImageView>(R.id.diceGif)
        val leftCard = findViewById<ImageView>(R.id.leftCard)
        val rightCard = findViewById<ImageView>(R.id.rightCard)

        startButton.setOnClickListener {
            diceGif.visibility = View.INVISIBLE
            val leftNumber = (1..6).shuffled().last()
            val rightNumber = (1..6).shuffled().last()
            if (leftNumber == 2) {
                leftCard.setImageResource(R.drawable.icon2)
            } else if (leftNumber == 3) {
                leftCard.setImageResource(R.drawable.icon3)
            } else if (leftNumber == 4) {
                leftCard.setImageResource(R.drawable.icon4)
            } else if (leftNumber == 5) {
                leftCard.setImageResource(R.drawable.icon5)
            } else if (leftNumber == 6) {
                leftCard.setImageResource(R.drawable.icon6)
            } else {
                leftCard.setImageResource(R.drawable.icon1)
            }

            if (rightNumber == 2) {
                rightCard.setImageResource(R.drawable.icon2)
            } else if (rightNumber == 3) {
                rightCard.setImageResource(R.drawable.icon3)
            } else if (rightNumber == 4) {
                rightCard.setImageResource(R.drawable.icon4)
            } else if (rightNumber == 5) {
                rightCard.setImageResource(R.drawable.icon5)
            } else if (rightNumber == 6) {
                rightCard.setImageResource(R.drawable.icon6)
            } else {
                rightCard.setImageResource(R.drawable.icon1)
            }

            leftCard.visibility = View.VISIBLE
            rightCard.visibility = View.VISIBLE
        }
    }
}
