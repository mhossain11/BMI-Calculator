package com.faysalh.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.faysalh.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
   var weightString = "52"
    var ageString = "21"
    var gender ="0"
    var progressString ="170"
    var intWeight = 52
    var intAge = 21

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this,R.color.black)
        binding.male.setOnClickListener {
            binding.male.background = ContextCompat.getDrawable(applicationContext,R.drawable.malefemalefocus)
           binding.female.background= ContextCompat.getDrawable(applicationContext,R.drawable.malefemalenotfocus)
            gender = "Male"
        }

        binding.female.setOnClickListener {

            binding.female.background= ContextCompat.getDrawable(applicationContext,R.drawable.malefemalefocus)
           binding.male.background = ContextCompat.getDrawable(applicationContext,R.drawable.malefemalenotfocus)
            gender = "Female"
        }

        //SeekBar
        binding.seekbarforheight.max = 300
        binding.seekbarforheight.progress= 170
        binding.seekbarforheight.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressString = progress.toString()
                binding.currentheight.text = progressString
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.incrementweight.setOnClickListener {
             intWeight+=1
            weightString =intWeight.toString()
          binding.currentweight.text= weightString
        }

        binding.decrementweight.setOnClickListener {
             intWeight -= 1
            weightString =intWeight.toString()
            binding.currentweight.text = weightString

        }


        binding.incrementage.setOnClickListener {
            intAge+=1
            ageString = intAge.toString()
            binding.currentage.text= ageString
        }

        binding.decrementage.setOnClickListener {
            intAge-=1
            ageString = intAge.toString()
            binding.currentage.text= ageString
        }

        //Button
        binding.calcuaterbmi.setOnClickListener {

            validation()

        }




    }

    private fun validation() {
        if (gender == "0"){
            Toast.makeText(this, "Select Your Gender", Toast.LENGTH_SHORT).show()
        }
        else if (progressString == "0"){
            Toast.makeText(this, "Select Your Height", Toast.LENGTH_SHORT).show()
        }
        else if (intAge == 0 || intAge<0){
            Toast.makeText(this, "Age is Incorrect", Toast.LENGTH_SHORT).show()
        }
        else if (intWeight == 0 || intWeight<0){
            Toast.makeText(this, "Weight is Incorrect", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(this,BmiActivity::class.java)
            intent.putExtra("gender", gender)
            intent.putExtra("height",progressString)
            intent.putExtra("weight",weightString)
            startActivity(intent)
            finish()
        }
    }


}