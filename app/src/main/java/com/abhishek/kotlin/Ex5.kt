package com.abhishek.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ex5 : AppCompatActivity() {
    lateinit var sumButton : Button
    lateinit var subButton : Button
    lateinit var mulButton : Button
    lateinit var divButton : Button
    lateinit var editText1 : EditText
    lateinit var editText2 : EditText
    lateinit var result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex5)

        sumButton = findViewById(R.id.sumButton)
        subButton = findViewById(R.id.subButton)
        mulButton = findViewById(R.id.multButton)
        divButton = findViewById(R.id.divButton)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        result = findViewById(R.id.sumTextView)

//        mulButton.setVisibility(View.GONE);
//        divButton.setVisibility(View.GONE);


        sumButton.setOnClickListener(View.OnClickListener {
            var temp = editText1.text.toString().toInt() + editText2.text.toString().toInt()
            result.setText(temp.toString())
        })

        subButton.setOnClickListener(View.OnClickListener {
            var temp = editText1.text.toString().toInt() - editText2.text.toString().toInt()
            result.setText(temp.toString())
        })

        mulButton.setOnClickListener(View.OnClickListener {
            var temp = editText1.text.toString().toInt() * editText2.text.toString().toInt()
            result.setText(temp.toString())
        })

        divButton.setOnClickListener(View.OnClickListener {
            var temp = editText1.text.toString().toInt() / editText2.text.toString().toInt()
            result.setText(temp.toString())
        })
    }
}