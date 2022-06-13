package com.example.makedogame

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

// List of questions
var questions = mutableListOf(
    "Many people __ more than the 30 kilometre per hour speed limit in this area",
    "Jane has just applied to __ a further education course to help her acquire new skills for her job",
    "Jack __ the newspaper crossword every day and usually completes it",
    "Jennifer __ a drawing of me that really captures my likeness "
)
// List of answers according to questions list sequence
var answer = mutableListOf(
    "make", "do", "does", "did"
)

var teamNumber = mutableListOf<String>()
var teamLead = mutableListOf<String>()
var teamSize = mutableListOf<String>()
var countTeams = 0
var countLead = 0
var countSize = 0

@SuppressLint("StaticFieldLeak")
lateinit var button: Button
@SuppressLint("StaticFieldLeak")
lateinit var editText: EditText
@SuppressLint("StaticFieldLeak")
lateinit var editTextM: EditText
@SuppressLint("StaticFieldLeak")
lateinit var editTextL: EditText
lateinit var stringM: String
lateinit var stringL: String
lateinit var string: String
@SuppressLint("StaticFieldLeak")
lateinit var textView: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("CutPasteId")
    fun participant(view: View){
        setContentView(R.layout.team_info)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        editTextM = findViewById(R.id.editTextM)
        editTextL = findViewById(R.id.editTextM)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            string = editText.text.toString()
            stringM = editTextM.text.toString()
            stringL = editTextL.text.toString()
            teamNumber.add(string)
            teamLead.add(stringL)
            teamSize.add(stringM)
            textView.text = teamLead.size.toString()
            countTeams += 1
            countLead += 1
            countSize += 1
        }
    }

    fun results(view: View){
        setContentView(R.layout.result)
    }

    fun questions(view: View){
        setContentView(R.layout.questions)
        val textView = findViewById<TextView>(R.id.textView18)
        val ans = findViewById<TextView>(R.id.textView12)
        val randomIndex = Random.nextInt(questions.size)
        textView.text = questions[randomIndex]
        ans.text = answer[randomIndex]

        val btnName = mutableListOf(
            "make", "do", "does", "did", "done", "made"
        )

        val ansBtn = mutableListOf<Button>(
            findViewById(R.id.button6), findViewById(R.id.button7),
            findViewById(R.id.button8), findViewById(R.id.button4),
            findViewById(R.id.button10), findViewById(R.id.button5)
        )

        for (i in ansBtn.indices){
            ansBtn[i].text = btnName[i]
            val ansView = findViewById<TextView>(R.id.textView19)

            ansBtn[i].setOnClickListener{

                if (answer[randomIndex] == btnName[i]){
                    ansView.text = "Correct answer"
                    ansBtn[i].setBackgroundColor(Color.GREEN)
                    ansBtn[0].isEnabled = false
                    ansBtn[1].isEnabled = false
                    ansBtn[2].isEnabled = false
                    ansBtn[3].isEnabled = false
                    ansBtn[4].isEnabled = false
                    ansBtn[5].isEnabled = false

                }

                else {
                    ansView.text = "Wrong answer"
                    ansBtn[i].setBackgroundColor(Color.RED)
                    ansBtn[randomIndex].setBackgroundColor(Color.GREEN)
                    ansBtn[0].isEnabled = false
                    ansBtn[1].isEnabled = false
                    ansBtn[2].isEnabled = false
                    ansBtn[3].isEnabled = false
                    ansBtn[4].isEnabled = false
                    ansBtn[5].isEnabled = false





                }

            }
        }

    }
}