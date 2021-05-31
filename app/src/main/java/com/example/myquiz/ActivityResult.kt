package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class ActivityResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_result)

        val username= intent.getStringExtra(GenerateQuestion.USER_NAME)
        findViewById<TextView>(R.id.tv_name).text= username
        val correctAnswer= intent.getIntExtra(GenerateQuestion.CORRECT_ANSWER, 0)
        val total= intent.getIntExtra(GenerateQuestion.TOTAL_QUESTION,0)
        findViewById<TextView>(R.id.tv_score).text="Your score is $correctAnswer out of $total !"

        findViewById<Button>(R.id.btn_finish).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}