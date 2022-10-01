package com.abhishek.kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Ex4 : AppCompatActivity() {
    lateinit var button : Button
    lateinit var editText : EditText
    var number : Long = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)

        button = findViewById(R.id.dialButton)
        editText = findViewById(R.id.editText)

        button.setOnClickListener(View.OnClickListener {
            number = editText.text.toString().toLong();
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + number)
            startActivity(intent)

        })

    }
}