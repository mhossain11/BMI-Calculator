package com.faysalh.bmi_calculator

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faysalh.bmi_calculator.databinding.ActivityBmiactivityBinding

class BmiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBmiactivityBinding
    var bmiCalculator :Double= 0.0
     var intHeight:Double = 0.0
     var intWeight:Double =0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val  height = intent.getStringExtra("height")
         val  weight = intent.getStringExtra("weight")

        calculate(height.toString().toDouble(),weight.toString().toDouble())


        binding.recalcuaterbmi.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun calculate(height: Double, weight: Double) {
        intHeight = height
        intWeight = weight

        intHeight /= 100
        bmiCalculator = intWeight / (intHeight * intHeight)

        bmiCalculate(bmiCalculator)

    }


    private fun bmiCalculate(bmiCalculator: Double) {
        if (bmiCalculator<16){
            binding.bmicategory.text="Severe Thinness"
            binding.contenlayout.setBackgroundColor(Color.RED)
            binding.imageview.setImageResource(R.drawable.crosss)
        }
        else if (bmiCalculator<16.9 && bmiCalculator>16){

            binding.bmicategory.text="Moderate Thinness"
            binding.contenlayout.setBackgroundColor(Color.YELLOW)
            binding.imageview.setImageResource(R.drawable.warning)
        }
        else if (bmiCalculator<18.4 && bmiCalculator>17){

            binding.bmicategory.text="Mild Thinness"
            binding.contenlayout.setBackgroundColor(Color.RED)
            binding.imageview.setImageResource(R.drawable.warning)
        }
        else if (bmiCalculator<24.9 && bmiCalculator>18.5){

            binding.bmicategory.text="Normal"
           // binding.contenlayout.setBackgroundColor(Color.YELLOW)
            binding.imageview.setImageResource(R.drawable.ok)
        }
        else if (bmiCalculator<29.9 && bmiCalculator>25){

            binding.bmicategory.text="Overweight"
            binding.contenlayout.setBackgroundColor(Color.RED)
            binding.imageview.setImageResource(R.drawable.warning)
        }

        else{
            binding.bmicategory.text="Obese Class I"
            binding.contenlayout.setBackgroundColor(Color.RED)
            binding.imageview.setImageResource(R.drawable.warning)
        }
        val gender = intent.getStringExtra("gender")
        binding.genderdisplay.text=gender
        binding.bmidisplay.text = String.format("%.2f",bmiCalculator)

    }


}