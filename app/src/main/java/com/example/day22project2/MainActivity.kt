package com.example.day22project2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = arrayOf("Soumya", "Prastuti", "Ankit", "Pradeep", "Aman")
        val lastMsg =
            arrayOf("Hey dude!", "Fine", "Awesome", "The weather was cool", "Got an internship.")
        val lastMsgTime = arrayOf("6:40 AM", "07:00 AM", "08:00 AM", "09:00 AM", "10:10 PM")
        val phoneNumber =
            arrayOf("7897476526", "8009382289", "9026505685", "9827853792", "6528799790")
        val imgId = intArrayOf(
            R.drawable.pic5,
            R.drawable.pic4,
            R.drawable.pic3,
            R.drawable.pic2,
            R.drawable.pic1
        )
        // Initialize the user list
        userArrayList = ArrayList()
        // Traverse on each user
        for (eachIdx in name.indices) {
            var user = User(
                name[eachIdx],
                lastMsg[eachIdx],
                lastMsgTime[eachIdx],
                phoneNumber[eachIdx],
                imgId[eachIdx]
            )
            userArrayList.add(user)
        }
        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)
        listView.setOnItemClickListener { parent, view, position, id ->
            // Open a new activity
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]
            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)


        }
    }
}