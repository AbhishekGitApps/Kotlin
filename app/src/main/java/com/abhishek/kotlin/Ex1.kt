package com.abhishek.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Ex1 : AppCompatActivity() {
    lateinit var button :Button
    lateinit var userName :EditText
    lateinit var userPassword :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)

        button = findViewById(R.id.submit_button)
        userName = findViewById(R.id.userName)
        userPassword = findViewById(R.id.userPassword)

        button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, userName.text, Toast.LENGTH_SHORT).show()
            userName.onEditorAction(EditorInfo.IME_ACTION_DONE)
        })
    }
}