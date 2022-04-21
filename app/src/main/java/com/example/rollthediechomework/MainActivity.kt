package com.example.rollthediechomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rollthediechomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var TAG: String = "MainActivity"
    var random_number: Int = 0
    var SCORE_PLAYER_A: Int = 0
    var SCORE_PLAYER_B: Int = 0
    var ACTIVE_PLAYER_A: Boolean = true
    var ACTIVE_PLAYER_B: Boolean = false
    var GAME_POINT: Int = 100
    var GAME_END_MSG: String? = null
    var GAME_END_MSG_DEFAULT: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.diceImage.isEnabled = false

        binding.btnGamePlay.setOnClickListener {

            binding.diceImage.isEnabled = true

            SCORE_PLAYER_A = 0
            SCORE_PLAYER_B = 0

            binding.tvGameOverMsg.text = ""
            binding.tvGamePointFirst.text = "0"
            binding.tvGamePointSecond.text = "0"

            ACTIVE_PLAYER_A = true
            ACTIVE_PLAYER_B = false

            binding.diceImage.setImageResource(R.drawable.dice1)

        }
        binding.diceImage.setOnClickListener {

            random_number = (1..6).random()

            when (random_number) {
                1 -> {
                    binding.diceImage.setImageResource(R.drawable.dice1)
                }
                2 -> {
                    binding.diceImage.setImageResource(R.drawable.dice2)
                }
                3 -> {
                    binding.diceImage.setImageResource(R.drawable.dice3)
                }
                4 -> {
                    binding.diceImage.setImageResource(R.drawable.dice4)
                }
                5 -> {
                    binding.diceImage.setImageResource(R.drawable.dice5)
                }
                6 -> {
                    binding.diceImage.setImageResource(R.drawable.dice6)
                }
            }

            if (ACTIVE_PLAYER_A) {

                SCORE_PLAYER_A = SCORE_PLAYER_A + random_number

                binding.tvGamePointFirst.text = SCORE_PLAYER_A.toString()

                ACTIVE_PLAYER_A = false
                ACTIVE_PLAYER_B = true

                if (SCORE_PLAYER_A >= 100) {
                    GAME_END_MSG_DEFAULT = resources.getText(R.string.game_over_msg).toString()
                    GAME_END_MSG = GAME_END_MSG_DEFAULT + " Player A"
                    binding.tvGameOverMsg.text = GAME_END_MSG

                    binding.diceImage.isEnabled = false
                }

            } else {

                SCORE_PLAYER_B += random_number

                binding.tvGamePointSecond.text = SCORE_PLAYER_B.toString()

                ACTIVE_PLAYER_B = false
                ACTIVE_PLAYER_A = true

                if (SCORE_PLAYER_B >= 100) {
                    GAME_END_MSG_DEFAULT = resources.getText(R.string.game_over_msg).toString()
                    GAME_END_MSG = GAME_END_MSG_DEFAULT + " Player B"
                    binding.tvGameOverMsg.text = GAME_END_MSG

                    binding.diceImage.isEnabled = false
                }
            }
            Log.e(TAG, random_number.toString())
        }
    }
}
