package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv_results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btnMoveActivity)
        val btnMoveActivityWithData: Button = findViewById(R.id.btnMoveWithData)
        val btnMoveActivityWithObject: Button = findViewById(R.id.btnMoveWithObject)
        val btnDialNumber: Button = findViewById(R.id.btnDialNumberr)
        val btnMoveForResult: Button = findViewById(R.id.btnMoveForResult)
        btnDialNumber.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnMoveActivity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btnMoveWithData -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Fahri Maulana")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btnDialNumberr -> {
                val phoneNumber = "082230422105"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btnMoveWithObject -> {
                val person = person(
                    "Fahri Maulana",
                    "fahri@gmail.com",
                    "Bandung"
                )
                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btnMoveForResult -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivity(moveForResultIntent)
            }
        }
    }
}