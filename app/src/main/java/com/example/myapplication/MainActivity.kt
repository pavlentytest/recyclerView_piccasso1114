package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder


data class Student(val firstname: String, val lastname:String, val url: String)

class MainActivity : AppCompatActivity() {

    private lateinit var students: List<Student>
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recycler)
        val resultString = application.assets
            .open("student.json")
            .bufferedReader()
            .use { it.readText() }
        val gson = GsonBuilder().create()
        students = gson.fromJson(resultString,Array<Student>::class.java).toList()
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter(students)

    }
}