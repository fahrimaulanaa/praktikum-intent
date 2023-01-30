package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)
        val tvObjectReceived: TextView = findViewById(R.id.tv_object)
        val person = intent.getParcelableExtra<person>(EXTRA_PERSON) as person
        val text = "Name: ${person.name.toString()},\nEmail: ${person.email},\nLocation: ${person.city}"
        tvObjectReceived.text = text

    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}