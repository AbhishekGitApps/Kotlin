package com.abhishek.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView1 :TextView
    lateinit var textView2 :TextView
    lateinit var textView3 :TextView
    lateinit var textView4 :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.ex1)
        textView2 = findViewById(R.id.ex2)
        textView3 = findViewById(R.id.ex3)
        textView4 = findViewById(R.id.ex4)

        textView1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex1::class.java)
            startActivity(intent)
        })

        textView2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex2::class.java)
            startActivity(intent)
        })

        textView3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex3::class.java)
            startActivity(intent)
        })

        textView4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex4::class.java)
            startActivity(intent)
        })


    }
}
//HEllo