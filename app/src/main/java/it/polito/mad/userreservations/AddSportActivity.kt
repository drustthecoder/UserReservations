package it.polito.mad.userreservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddSportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sport)

        val sportname = findViewById<EditText>(R.id.sportName)
        val sportlevel = findViewById<EditText>(R.id.sportLevel)
        val sportAchievements = findViewById<EditText>(R.id.sportAchievements)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener{

        }

    }
}