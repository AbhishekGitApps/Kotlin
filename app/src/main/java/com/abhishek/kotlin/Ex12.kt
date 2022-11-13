package com.abhishek.kotlin

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Ex12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex12)

        val databaseHandler: DatabaseHandler= DatabaseHandler(this)
        val status = databaseHandler.addEmployee(ModelClass(Integer.parseInt("1"),"Abhishek", "abhishek@gmail.com"))
        val status1 = databaseHandler.addEmployee(ModelClass(Integer.parseInt("2"),"Abhi", "abhi@gmail.com"))
        val status2 = databaseHandler.addEmployee(ModelClass(Integer.parseInt("3"),"Ab", "ab@gmail.com"))

        val emp: List<ModelClass> = databaseHandler.viewEmployee()
        val empArrayId = Array<String>(emp.size){"0"}
        val empArrayName = Array<String>(emp.size){"null"}
        val empArrayEmail = Array<String>(emp.size){"null"}
        var index = 0
        for(e in emp){
            empArrayId[index] = e.userId.toString()
            empArrayName[index] = e.userName
            empArrayEmail[index] = e.userEmail
            index++
        }
        //creating custom ArrayAdapter
        var listView: ListView = findViewById(R.id.listView)
        val myListAdapter = MyListAdapter(this,empArrayId,empArrayName,empArrayEmail)
        listView.adapter = myListAdapter
    }
}