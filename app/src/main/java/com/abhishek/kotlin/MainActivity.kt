package com.abhishek.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView1:TextView = findViewById(R.id.ex1)
        var textView2:TextView = findViewById(R.id.ex2)
        var textView3:TextView = findViewById(R.id.ex3)
        var textView4:TextView = findViewById(R.id.ex4)
        var textView5:TextView = findViewById(R.id.ex5)
        var textView6:TextView = findViewById(R.id.ex6)
        var textView7:TextView = findViewById(R.id.ex7)
        var textView8:TextView = findViewById(R.id.ex8)
        var textView9:TextView = findViewById(R.id.ex9)
        var textView10:TextView = findViewById(R.id.ex10)
        var textView11:TextView = findViewById(R.id.ex11)
        var textView12:TextView = findViewById(R.id.ex12)
        var textView13:TextView = findViewById(R.id.ex13)

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

        textView5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex5::class.java)
            startActivity(intent)
        })

        textView6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex6::class.java)
            startActivity(intent)
        })

        textView7.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex7::class.java)
            startActivity(intent)
        })

        textView8.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex8::class.java)
            startActivity(intent)
        })

        textView9.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex9::class.java)
            startActivity(intent)
        })

        textView10.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex10::class.java)
            startActivity(intent)
        })

        textView11.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex11::class.java)
            startActivity(intent)
        })

        textView12.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex12::class.java)
            startActivity(intent)
        })

        textView13.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Ex13::class.java)
            startActivity(intent)
        })




    }
}
//Hello Therer
