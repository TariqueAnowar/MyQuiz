package com.example.myquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition : Int=1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int=0
    private var mUserName:String?=null
    private var mCorrectAnswer:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName= intent.getStringExtra(GenerateQuestion.USER_NAME)
        setQuestion()
        findViewById<TextView>(R.id.tvOptionOne).setOnClickListener(this)
        findViewById<TextView>(R.id.tvOptionTwo).setOnClickListener(this)
        findViewById<TextView>(R.id.tvOptionThree).setOnClickListener(this)
        findViewById<TextView>(R.id.tvOptionFour).setOnClickListener(this)
        findViewById<Button>(R.id.btnSubmit).setOnClickListener(this)
    }

    private fun setQuestion(){
        mQuestionList= GenerateQuestion.getQuestion()
        val question= mQuestionList !! [mCurrentPosition-1]
        defaultOptionView()
        if(mCurrentPosition==mQuestionList!!.size){
            findViewById<Button>(R.id.btnSubmit).text="Finish"
        }
        else{
            findViewById<Button>(R.id.btnSubmit).text="Submit"
        }
        //ProgressBar
        findViewById<ProgressBar>(R.id.progressBar).progress= mCurrentPosition
        findViewById<TextView>(R.id.tvProgress).text= "${mCurrentPosition}/${findViewById<ProgressBar>(R.id.progressBar).max}"

        //Question
        findViewById<TextView>(R.id.tvQuestion).text= question.question
        findViewById<ImageView>(R.id.ivFlag).setImageResource(question.image)

        //options
        findViewById<TextView>(R.id.tvOptionOne).text= question.optionOne
        findViewById<TextView>(R.id.tvOptionTwo).text= question.optionTwo
        findViewById<TextView>(R.id.tvOptionThree).text= question.optionThree
        findViewById<TextView>(R.id.tvOptionFour).text= question.optionFour

    }

    private fun defaultOptionView(){
        val options= ArrayList<TextView>()
        options.add(0, findViewById(R.id.tvOptionOne))
        options.add(1, findViewById(R.id.tvOptionTwo))
        options.add(2, findViewById(R.id.tvOptionThree))
        options.add(3, findViewById(R.id.tvOptionFour))
        for (opt in options){
            opt.setTextColor(Color.parseColor("#7A8089"))
            opt.typeface= Typeface.DEFAULT
            opt.background= ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
        findViewById<Button>(R.id.btnSubmit).text="Submit"
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tvOptionOne->{
                selectedOptionView(findViewById(R.id.tvOptionOne), selectedOptionNum = 1)
            }
            R.id.tvOptionTwo->{
                selectedOptionView(findViewById(R.id.tvOptionTwo), selectedOptionNum = 2)
            }
            R.id.tvOptionThree->{
                selectedOptionView(findViewById(R.id.tvOptionThree), selectedOptionNum = 3)
            }
            R.id.tvOptionFour->{
                selectedOptionView(findViewById(R.id.tvOptionFour), selectedOptionNum = 4)
            }
            R.id.btnSubmit->{
                if (mSelectedOptionPosition==0){
                    mCurrentPosition++
                    if (mCurrentPosition<=mQuestionList!!.size){
                        setQuestion()
                    }
                    else{
                        val intent= Intent(this, ActivityResult::class.java)
                        intent.putExtra(GenerateQuestion.USER_NAME, mUserName)
                        intent.putExtra(GenerateQuestion.CORRECT_ANSWER, mCorrectAnswer)
                        intent.putExtra(GenerateQuestion.TOTAL_QUESTION, mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                }
                else{
                    val quesList= mQuestionList?.get(mCurrentPosition-1)
                    if (quesList!!.correctAnswer!= mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    }
                    else{
                        mCorrectAnswer++
                    }
                    answerView(quesList.correctAnswer, R.drawable.correct_option_border)
                    if (mCurrentPosition==mQuestionList!!.size){
                        findViewById<Button>(R.id.btnSubmit).text="Finish"
                    }
                    else{
                        findViewById<Button>(R.id.btnSubmit).text="Next Question"
                    }
                    mSelectedOptionPosition=0
                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView:Int){
        when(answer){
            1->{
                findViewById<TextView>(R.id.tvOptionOne).background= ContextCompat.getDrawable(this, drawableView)
            }
            2->{
                findViewById<TextView>(R.id.tvOptionTwo).background= ContextCompat.getDrawable(this, drawableView)
            }
            3->{
                findViewById<TextView>(R.id.tvOptionThree).background= ContextCompat.getDrawable(this, drawableView)
            }
            4->{
                findViewById<TextView>(R.id.tvOptionFour).background= ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this, R.drawable.selected_option_border)

    }
}