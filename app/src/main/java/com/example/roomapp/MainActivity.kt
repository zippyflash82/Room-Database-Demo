package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.roomapp.data.User
import com.example.roomapp.data.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java, "user.db"
        ).build()


        btn_insert.setOnClickListener{
          GlobalScope.launch {  val id =  db.userDao().addUser(User(0,"Muhammad " , "Shafique", 25))
              println("Data insert Id: $id")
          }
        }




    }



}