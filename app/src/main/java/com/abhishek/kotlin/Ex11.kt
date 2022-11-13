package com.abhishek.kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ex11 : AppCompatActivity() {
    lateinit var button : Button
    lateinit var editText : EditText
    lateinit var editText1 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex11)

        button = findViewById(R.id.emailButton)
        editText = findViewById(R.id.editText)
        editText1 = findViewById(R.id.editText1)

        button.setOnClickListener(View.OnClickListener {

            val email = editText.text.toString()
            val message = editText1.text.toString()

            /*ACTION_SEND action to launch an email client installed on your Android device.*/
            val mIntent = Intent(Intent.ACTION_SEND)
            /*To send an email you need to specify mailto: as URI using setData() method
            and data type will be to text/plain using setType() method*/
            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            // put recipient email in intent
            /* recipient is put as array because you may wanna send email to multiple emails
               so enter comma(,) separated emails, it will be stored in array*/
            mIntent.putExtra(Intent.EXTRA_EMAIL, email)
            //put the Subject in the intent
            mIntent.putExtra(Intent.EXTRA_SUBJECT, "Test")
            //put the message in the intent
            mIntent.putExtra(Intent.EXTRA_TEXT, message)


            try {
                //start email intent
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            }
            catch (e: Exception){
                //if any thing goes wrong for example no email client application or any exception
                //get and show exception message
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}