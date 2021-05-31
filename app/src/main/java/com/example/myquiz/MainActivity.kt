package com.example.myquiz

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Hide Status Bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        var btnStart= findViewById<Button>(R.id.btnStart)
        var etName= findViewById<EditText>(R.id.etName)

        btnStart.setOnClickListener {
            if (etName.text.toString().trim().isEmpty()){
                Toast.makeText(this, "Please enter name.", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent= Intent(this, QuizQuestionActivity:: class.java)
                intent.putExtra(GenerateQuestion.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }
}