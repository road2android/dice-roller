package com.hafijulislam.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class Dice(private val sides: Int = 6) {

    fun roll(): Int {
        return (1..this.sides).random()

    }
}

class MainActivity : AppCompatActivity() {


    var diceImage: ImageView? = null

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.imageView)

        val rollButton: Button = findViewById(R.id.rollButton)

        val resetButton: Button = findViewById(R.id.resetButton)

        resetImage()

        rollButton.setOnClickListener {

            val dice: Dice = Dice()

            val randomNumber: Int = dice.roll()

            if (randomNumber == 3) {
                Toast.makeText(
                    this,
                    "It's your Lucky number \uD83E\uDD73",
                    Toast.LENGTH_SHORT
                ).show()
            }

            this.updateImage(randomNumber)
        }

        resetButton.setOnClickListener {
            resetImage()
        }
    }

    private fun updateImage(number: Int) {

        val diceImage: ImageView = findViewById(R.id.imageView)

        diceImage.contentDescription = number.toString()

        (when (number) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        })
    }

    private fun resetImage() {

        diceImage?.setImageResource(R.drawable.dice_0)

        Toast.makeText(
            this,
            "Dice has been resetted",
            Toast.LENGTH_SHORT
        ).show()
    }
}