package com.abhishek.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ex3 : AppCompatActivity() {
    lateinit var button : Button
    lateinit var editText : EditText
    lateinit var reversedTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)

        button = findViewById(R.id.reverseButton)
        editText = findViewById(R.id.editText)
        reversedTextView = findViewById(R.id.reverseTextView)

        button.setOnClickListener(View.OnClickListener {
            var temp = editText.text.toString()
            temp = temp.reversed()
            reversedTextView.setText(temp)
            reversedTextView.visibility = View.VISIBLE
        })

    }
}