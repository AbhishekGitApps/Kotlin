package com.abhishek.kotlin

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Ex10 : AppCompatActivity() {
    lateinit var button : Button
    lateinit var editText : EditText
    lateinit var editText1 : EditText
//    var phoneNumber = "7992215467"
//    var message = "Hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex10)

        button = findViewById(R.id.dialButton)
        editText = findViewById(R.id.editText)
        editText1 = findViewById(R.id.editText1)

        button.setOnClickListener(View.OnClickListener {

            val phoneNumber = editText.text.toString()
            val message = editText1.text.toString()

            try {
                var smsManager: SmsManager
                if (Build.VERSION.SDK_INT >= 23) {

                    smsManager = applicationContext.getSystemService(SmsManager::class.java)
//                    smsManager = SmsManager.getDefault()
                } else {

                    smsManager = SmsManager.getDefault()
                }

                smsManager = applicationContext.getSystemService(SmsManager::class.java)
                smsManager.sendTextMessage(phoneNumber, null, message, null, null)
                Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()

            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Please enter all the data.."+e.message.toString(), Toast.LENGTH_LONG)
                    .show()
            }
        })

    }
}

