package com.example.myquiz

object GenerateQuestion{

    const val USER_NAME: String="user_name"
    const val CORRECT_ANSWER:String="correct"
    const val TOTAL_QUESTION: String="total"

    fun getQuestion(): ArrayList<Question> {
        val questionList= ArrayList<Question>()

        //first question
        val que1= Question(
            id = 1,
            image = R.drawable.ic_flag_of_argentina,
            question = "What country does this flag belong to?",
            optionOne = "Argentina",
            optionTwo = "Armenia",
            optionThree = "Austria",
            optionFour = "Australia",
            correctAnswer = 1
        )
        questionList.add(que1)

        //second question
        val que2= Question(
            id = 2,
            image = R.drawable.ic_flag_of_australia,
            question = "What country does this flag belong to?",
            optionOne = "Argentina",
            optionTwo = "Armenia",
            optionThree = "Austria",
            optionFour = "Australia",
            correctAnswer = 4
        )
        questionList.add(que2)

        //third question
        val que3= Question(
            id = 3,
            image = R.drawable.ic_flag_of_belgium,
            question = "What country does this flag belong to?",
            optionOne = "Bahamas",
            optionTwo = "Brunei",
            optionThree = "Belgium",
            optionFour = "Belarus",
            correctAnswer = 3
        )
        questionList.add(que3)

        //fourth question
        val que4= Question(
            id = 4,
            image = R.drawable.ic_flag_of_fiji,
            question = "What country does this flag belong to?",
            optionOne = "Fiji",
            optionTwo = "France",
            optionThree = "Caribbean",
            optionFour = "Utopia",
            correctAnswer = 1
        )
        questionList.add(que4)

        //five question
        val que5= Question(
            id = 5,
            image = R.drawable.ic_flag_of_germany,
            question = "What country does this flag belong to?",
            optionOne = "Greece",
            optionTwo = "Germany",
            optionThree = "Georgia",
            optionFour = "None of the above",
            correctAnswer = 2
        )
        questionList.add(que5)

        //six question
        val que6= Question(
            id = 6,
            image = R.drawable.ic_flag_of_india,
            question = "What country does this flag belong to?",
            optionOne = "Sri Lanka",
            optionTwo = "Bangladesh",
            optionThree = "Pakistan",
            optionFour = "India",
            correctAnswer = 4
        )
        questionList.add(que6)

        //seven question
        val que7= Question(
            id = 7,
            image = R.drawable.ic_flag_of_denmark,
            question = "What country does this flag belong to?",
            optionOne = "Denmark",
            optionTwo = "Italy",
            optionThree = "Belgium",
            optionFour = "Switzerland",
            correctAnswer = 1
        )
        questionList.add(que7)
        return questionList
    }
}