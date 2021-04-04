package alaa.ewis.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.DrawableRes

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Saves a reference to the Button object in a variable called rollButton.
        val rollButton: Button = findViewById(R.id.button)

        // "listening" for the user to click.
        rollButton.setOnClickListener {
            rollDice()
        };
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it.
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the Image Views in the layoutز
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Update the Image Views with the correct drawable resource ID
        diceImage.setImageResource(rolldrawable(diceRoll))
        diceImage2.setImageResource(rolldrawable(diceRoll2))

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }

    // Determine which drawable resource ID to use based on the dice rollز
    private fun rolldrawable(diceRoll: Int) : Int {
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }
}

class Dice(private val numSides: Int) {
    // Get random number from one to passed number of dice sides.
    fun roll(): Int {
        return (1..numSides).random()
    }
}