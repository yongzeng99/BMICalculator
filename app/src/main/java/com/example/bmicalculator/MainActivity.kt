package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var heightInput: EditText
    lateinit var weightInput: EditText
    lateinit var resultImage: ImageView
    lateinit var setResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultImage = findViewById(R.id.imageViewProfile)
        heightInput= findViewById(R.id.editTextHeight)
        weightInput = findViewById(R.id.editTextWeight)
        setResult = findViewById(R.id.textViewBMI)
        val calculateButton : Button = findViewById(R.id.buttonCalculate)
        val resetButton : Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener{ calculateBMI() }
        resetButton.setOnClickListener { resetBMI() }
    }

    private fun calculateBMI(){
        //convert cm to meters
        val heightDouble: Double = heightInput.text.toString().toDouble() / 100
        val weightDouble: Double = weightInput.text.toString().toDouble()
        val result: Double =  weightDouble / Math.pow(heightDouble, 2.0)

        resultImage.setImageResource(R.drawable.empty)

        if (result < 18.5){
            resultImage.setImageResource(R.drawable.under)
        } else if (result >= 18.5 && result <= 24.9){
            resultImage.setImageResource(R.drawable.normal)
        } else if (result >= 25){
            resultImage.setImageResource(R.drawable.over)
        }

        setResult.setText("BMI : "+ String.format("%.2f", result))
    }

    private fun resetBMI(){

        resultImage.setImageResource(R.drawable.empty)
        setResult.setText("BMI : ")
        heightInput.setText("")
        weightInput.setText("")

    }
}
