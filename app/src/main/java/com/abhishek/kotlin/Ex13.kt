package com.abhishek.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Ex13 : AppCompatActivity() {
    lateinit var userName:EditText
    lateinit var userPassword:EditText
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex13)

        userName = findViewById(R.id.user_name)
        userPassword = findViewById(R.id.user_password)
        btn = findViewById(R.id.login_btn)
        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        val status = databaseHandler.addEmployee(ModelClass(Integer.parseInt("1"),"Hanshit", "password"))
        val emp: List<ModelClass> = databaseHandler.viewEmployee()

        btn.setOnClickListener(View.OnClickListener {
            if(userName.text.toString().equals(emp.get(0).userName) &&
                    userPassword.text.toString().equals(emp.get(0).userEmail)) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("key", emp.get(0).userName)
                startActivity(intent)
            } else {
                val myToast = Toast.makeText(applicationContext,"Wrong Password",Toast.LENGTH_SHORT)
                myToast.show()

            }

        })
    }
}