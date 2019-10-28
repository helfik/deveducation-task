package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val diceGif = findViewById<ImageView>(R.id.diceGif)
        val leftCard = findViewById<ImageView>(R.id.leftCard)
        val rightCard = findViewById<ImageView>(R.id.rightCard)
        var leftCount = findViewById<TextView>(R.id.leftCount)
        var rightCount = findViewById<TextView>(R.id.rightCount)
        var leftScore = 0
        var rightScore = 0

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

            if (leftNumber > rightNumber) {
                    leftScore++
                    leftCount.text = leftScore.toString()
                } else if (leftNumber < rightNumber) {
                    rightScore++
                    rightCount.text = rightScore.toString()
                } else if (leftNumber == rightNumber) {
                    leftScore++
                    rightScore++
                    rightCount.text = rightScore.toString()
                    leftCount.text = leftScore.toString()
                } else {
                    Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
                }

            if ( leftScore >= 10 ) {
                Toast.makeText(this, "Left gamer Win!", Toast.LENGTH_SHORT).show()
                leftScore = 0
                rightScore = 0
                leftCount.text = leftScore.toString()
                rightCount.text = rightScore.toString()
            } else if (rightScore >= 10){
                Toast.makeText(this, "Right Gamer Won!", Toast.LENGTH_SHORT).show()
                leftScore = 0
                rightScore = 0
                leftCount.text = leftScore.toString()
                rightCount.text = rightScore.toString()
            } else if (leftScore==10 && rightScore==10){
                Toast.makeText(this, "Oops, please play again", Toast.LENGTH_SHORT).show()
                leftScore = 0
                rightScore = 0
                leftCount.text = leftScore.toString()
                rightCount.text = rightScore.toString()
            }

        }

    }

}
