package com.abhishek.kotlin

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Ex6 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex6)

        val radioGroup:RadioGroup = findViewById(R.id.radio_group)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(
                applicationContext,
                " On checked change :" + " ${radio.text}",
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}