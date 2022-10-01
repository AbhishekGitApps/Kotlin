package com.abhishek.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ex2 : AppCompatActivity() {
    lateinit var button : Button
    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var sum : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)

        button = findViewById(R.id.sumButton)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        sum = findViewById(R.id.sumTextView)

        button.setOnClickListener(View.OnClickListener {
            var temp = editText1.text.toString().toInt() + editText2.text.toString().toInt()
            sum.setText(temp.toString())
        })
    }
}