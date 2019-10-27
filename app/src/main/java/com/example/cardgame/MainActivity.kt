package com.example.cardgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val startButton = findViewById<Button>(R.id.startButton)
    val diceGif = findViewById<ImageView>(R.id.diceGif)
    val leftCard = findViewById<ImageView>(R.id.leftCard)
    val rightCard = findViewById<ImageView>(R.id.rightCard)
    internal lateinit var leftCount: TextView
    internal lateinit  var rightCount: TextView
    var leftScore = 0
    var rightScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                } else {
                    Toast.makeText(this, "The End", Toast.LENGTH_SHORT).show()
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
